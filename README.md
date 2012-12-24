# hashthread

A Clojure threading macro, like `->` and `->>`, but with explicit threadpoints.

```clojure
eg. (-#> 5
         (range % 10)
         (map inc %))

=> (6 7 8 9 10)
```

## Usage

Add `[hashthread "0.1.0"]` to your leiningen `:dependencies`.

Then `(:use hashthread.core)` in your Clojure source namespace declaration.

## Note

Hashthread doesn't play well with `#(* 2 %)`-style functions, because they'll
fight over the meaning of `%`.  This is a _deliberate_ design decision, to
clobber the same symbol rather than reserve a new one.

If you dislike this, you might be best off forking the code - it's actually only
6 lines. But nudge me too. I'm persuadable...

## License

Copyright © 2012 Kris Jenkins

Distributed under the Eclipse Public License, the same as Clojure.
