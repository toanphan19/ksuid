(ns ksuid.base62-test
  (:require  [clojure.test :refer :all]
             [ksuid.base62 :refer :all]))

(deftest encode-bytes-test
  (testing "Test encode base62")
  (is (= "0" (encode-bytes (byte-array 4))))
  (is (= "1d" (encode-bytes (byte-array [101])))))

(deftest encode-decode-bytes-test
  (testing "Test encode and decode base62"
    (is (= "0" (encode-bytes (decode-bytes "0"))))
    (is (= "2DdhyDxLNUQWoag0Webut0ahEVc" (encode-bytes (decode-bytes "2DdhyDxLNUQWoag0Webut0ahEVc"))))))

(deftest base62?-test
  (is (base62? "2DdhyDxLNUQWoag0Webut0ahEVc"))
  (is (not (base62? "123+"))))
