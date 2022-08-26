(ns ksuid.base62
  (:require clojure.string)
  (:require clojure.set))

(def charset "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz")

(defn- base62-value
  [ch]
  (let [offet-uppercase 10
        offset-lowercase 36]
    (cond
      (and (>= (compare ch \0) 0) (<= (compare ch \9) 0)) (compare ch \0)
      (and (>= (compare ch \A) 0) (<= (compare ch \Z) 0)) (+ (compare ch \A) offet-uppercase)
      :else (+ offset-lowercase (compare ch \a)))))

(defn encode
  [num]
  (let [string-builder (StringBuilder.)]
    (if (zero? num)
      "0"
      (do
        (loop [num num]
          (when (pos? num)
            (.append string-builder (nth charset (mod num 62)))
            (recur (quot num 62))))
        (-> (.reverse string-builder)
            (.toString))))))

(defn encode-bytes
  "Encode a byte-array in base62."
  [bytes]
  ;; convert to unsigned bigint and encode as a number
  (encode (BigInteger. 1 bytes)))

(defn decode
  "Decode a base62 string into a number."
  [s]
  (if (empty? s)
    0
    (reduce (fn [num char] (+ (* num 62) (base62-value char)))
            (bigint 0)
            s)))

(defn decode-bytes
  "Decode a base62 string into a byte-array"
  [s]
  (-> (decode s)
      (biginteger)
      (.toByteArray)))

(defn base62?
  "Check if a string is encoded in base62."
  [s]
  (-> (clojure.set/difference (set s) (set charset))
      (count)
      (zero?)))
