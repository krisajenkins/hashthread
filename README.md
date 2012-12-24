# hashthread

A clojure threading macro, like `->` and `->>`, but with explicit threadpoints.

```clojure
  eg. (-#> 5
           (range % 10)
           (map inc %))

  => (6 7 8 9 10)"
```

## Usage

Add `hashthread ["0.1.0"]` to your leiningen `:dependencies`.
Then `(:use hashthread.core)` in your Clojure source namespace declaration.

## License

Copyright © 2012 Kris Jenkins

Distributed under the Eclipse Public License, the same as Clojure.
