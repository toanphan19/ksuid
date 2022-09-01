# KSUID

[![Clojars Project](https://img.shields.io/clojars/v/com.github.toanphan19/ksuid.svg?include_prereleases)](https://clojars.org/com.github.toanphan19/ksuid)

KSUID implemented in Clojure.

## What is a KSUID?

KSUID is a K-Sortable Unique Identifier. It stores a time component besides the random payload and thus can be sorted based on generation time. This library follows the original [Segment's KSUID](https://github.com/segmentio/ksuid) implementation which has a 1 second precision on the timestamp.

Read more [here](https://github.com/segmentio/ksuid) on why to use it over other identifiers.

## Install

Leiningen

```sh
[com.github.toanphan19/ksuid "0.1.0"]
```

Clojure CLI/deps.edn

```sh
com.github.toanphan19/ksuid {:mvn/version "0.1.0"}
```

## Usage

### Import into your namespace

```clj
(ns my.ns
  (:require [ksuid.core :as ksuid]))
```

### Generate a new KSUID

```clj
(ksuid/new-random)
=> {:timestamp 261641632,
    :payload [-104, -49, ...],
    :bytes [15, -104, 85, -96, -104, -49, ...]}

;; Get the string representation
(ksuid/string (ksuid/new-random))
=> "2DdhyDxLNUQWoag0Webut0ahEVc"
;; Extract the time
(ksuid/time-instant (ksuid/new-random))
=> #object[java.time.Instant 0xda0dc02 "2022-08-27T23:17:06Z"]

;; Decode a ksuid string
(ksuid/from-string "2DdhyDxLNUQWoag0Webut0ahEVc")
=> {:timestamp 261641632,
    :payload [-104, -49, ...],
    :bytes [15, -104, 85, -96, -104, -49, ...]}
```
