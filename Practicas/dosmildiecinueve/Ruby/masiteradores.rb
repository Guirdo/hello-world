# Iteradores:
# Times, upto, downto

puts "Iterador times"
10.times do |i|
    print "#{i+1},"
end
puts "------------\n"

puts "Iterador Upto"

1.upto(10) do |i|
    puts i
end
puts "------------\n"

puts "Iterador downto"
10.downto(1) do |i|
    puts i
end