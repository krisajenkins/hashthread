(ns hashthread.core)

(defmacro -#>
  "Thread expr through the forms.

  Similar to -> and ->>, but the threading point is explicitly specified
  with a % character in each form.

  eg. (-#> 5
           (range % 10)
           (map inc %))

  => (6 7 8 9 10)"
  ([expr] expr)
  ([expr form] `(let [~'% ~expr]
                  ~form))
  ([expr form & forms] `(-#> (-#> ~expr ~form)
                             ~@forms)))
