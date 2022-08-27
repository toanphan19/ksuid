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
    (is (valid? (string (new-random))))))
