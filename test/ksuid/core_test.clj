(ns ksuid.core-test
  (:require [clojure.test :refer :all]
            [ksuid.core :refer :all]))

(deftest valid?-test
  (testing "Test valid KSUID"
    (is (not (valid? "tooShort")))
    (is (not (valid? "tooLong2DdhyDxLNUQWoag0Webut0ahEVc")))
    (is (not (valid? "=27chars_with_special_chars")))
    (is (valid? "2DdhyDxLNUQWoag0Webut0ahEVc"))))

(deftest new-random-test
  (testing "Test generating a random KSUID"
    (is (= 20 (count (:bytes (new-random)))))
    (is (instance? java.time.Instant (time-instant (new-random))))
    (is (valid? (to-string (new-random))))))

(deftest from-string-test
  (let [s "2EBQ7WtWHffEn6vGMlElzUhcEvO"
        timestamp 262066330
        expected-bytes (byte-array [15, -98, -48, -102, 82, -6, 91, -59, -25, -90, 103, -102, 6, 89, 73, 26, 79, -100, -1, -98])
        computed-ksuid (from-string s)]
    (is (= s (to-string computed-ksuid)))
    (is (= timestamp (:timestamp computed-ksuid)))
    (is (java.util.Arrays/equals expected-bytes (:bytes computed-ksuid)))))
