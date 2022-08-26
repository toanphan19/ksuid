(ns ksuid.base62-test
  (:require  [clojure.test :refer :all]
             [ksuid.base62 :refer :all]))

(deftest encode-decode-test
  (testing "Test Base62 encode and decode"
    (is (= "0" (encode (decode "0"))))
    (is (= "2DdhyDxLNUQWoag0Webut0ahEVc" (encode (decode "2DdhyDxLNUQWoag0Webut0ahEVc"))))))

(deftest encode-bytes-test
  (testing "Test encode base62")
  (is (= "0" (encode-bytes (byte-array 10)))))

(deftest base62?-test
  (is (base62? "2DdhyDxLNUQWoag0Webut0ahEVc"))
  (is (not (base62? "123+"))))
