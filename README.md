# KSUID

KSUID implemented in Clojure.

## What is a KSUID?

KSUID is a K-Sortable Unique Identifier. It stores a time component besides the random payload and thus can be sorted based on generation time. This library follows the original [Segment's KSUID](https://github.com/segmentio/ksuid) implementation which has a 1 second precision on the timestamp.

Read more [here](https://github.com/segmentio/ksuid) on why to use it over other identifiers.

## Install

```
TODO
```

## Usage

```clj
;; In your ns statement:
(ns my.ns
  (:require [ksuid.core :as ksuid]))
```

```clj
(string (ksuid/new-random))
```
