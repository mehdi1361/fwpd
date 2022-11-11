(ns fwpd.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def filename "suspects.csv")
(slurp filename)

(def vamp-keys [:name :glitter-index])
(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity :glitter-index str->int})

(defn convert
  [vamp-keys value]
  ((get conversions vamp-keys) value))

(convert :glitter-index "3")
(convert :glitter-index "4")

(clojure.string/split (slurp filename) #"\n")

(defn parse
  "Convert a csv into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(parse (slurp filename))

(defn mapify
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key rows)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(first (mapify (parse (slurp filename))))
(first (mapify (parse (slurp filename))))

(map vector vamp-keys (parse (slurp filename)))
(parse (slurp filename))
(map vector vamp-keys (slurp filename))

(defn wisdom
  [word]
  (str word ", mehdi mousavi"))

(wisdom "Alway in Bathe")

(defn end-year-evolution
  []
  (if (> (rand) 0.5)
    "You get a raise"
    "Better Luck next year"))

(end-year-evolution)
(rand)

(defn analysis
  [text]
  (str "text count:" (count text)))

(defn analyze-file
  [filename]
  (analysis (slurp filename)))

(analyze-file filename)


(def great-baby-name "RosAnthony")
(println great-baby-name)

(let [great-baby-name "BloodThunder"]
  great-baby-name)

(defn m-sum
  ([vals] (m-sum vals 0))
  ([vals accumulating-totals]
   (if (empty? vals)
     accumulating-totals
     (m-sum (rest vals) (+ (first vals) accumulating-totals)))
  ))

(m-sum [1 2 3])
(m-sum [1 2 3] 3)

(require '[clojure.string :as s])
(defn clean
  [text]
  (s/replace (s/trim text) #"lol" "LOL"))

(clean "My Boa constrictor is so sassy lol")

((comp inc *) 2 3)

(def character
  {:name "Smooches McCutes"
   :attributes {:inteligence 10
                :strength 4
                :dexterity 5}})

(def c-int (comp :inteligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(c-int character)

(defn spell-slots
  [char]
  (int (inc (/ (c-int char) 2))))

(spell-slots character)

(def spell-slot-comps (comp int inc #(/ % 2) c-int))
(spell-slot-comps character)
