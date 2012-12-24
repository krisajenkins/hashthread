(ns hashthread.test.core
  (:use clojure.test
        hashthread.core))

(deftest hashthread-test
  (is (= (-#> 10) 10))

  (is (= (-#> 5
              (range % 10))
         [5 6 7 8 9]))

  (is (= (let [n 5] (-#> n
                         (range % 10)))
         [5 6 7 8 9]))

  (is (= (-#> 5
              (range % 10)
              (map (fn [x] (* 2 x)) %)
              (reduce + %))
         70)))

(deftest hashthread-side-effects-test
  (let [call-count (atom 0)
        read-and-inc (fn [& args]
                       (swap! call-count inc)
                       args)]

    (-#> nil
         (read-and-inc %)
         (read-and-inc % % %)
         (read-and-inc % % %))

    ; Read-and-inc should be called *exactly* three times.
    (is (= 3 @call-count))))
