nums = -1..9
puts nums.include?(5)
puts nums.min
puts nums.max
puts nums.reject{|i|i<5}

puts (1..10) === 5
puts (1..10) === 15
puts (1..10) === 3.14
puts ('a'..'j') === 'c'