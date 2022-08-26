(ns ksuid.core-test
  (:require [clojure.test :refer :all]
            [ksuid.core :refer :all]))

(deftest valid?-test
  (testing "Test valid KSUID"
    (is (not (valid? "895f0b8f-13c9-430c-b8bf-be5f6c8e5eef")))
    ;; TODO
    ;; (is (not (valid? "+/dhyDxLNUQWoag0Webut0ahEVc")))  
    (is (valid? "2DdhyDxLNUQWoag0Webut0ahEVc"))
    (is (valid? (:string (ksuid.core/new-random))))))


(comment
  "REPRESENTATION:

  String: 2DfHHm9eA1ugeAYXeXve6ZAdtWV
     Raw: 0F8FCFFCF9A8E48B498FAA66CEA8551D39ED7A43

COMPONENTS:

       Time: 2022-08-21 13:58:52 +0200 CEST
  Timestamp: 261083132
    Payload: F9A8E48B498FAA66CEA8551D39ED7A43
   ")

