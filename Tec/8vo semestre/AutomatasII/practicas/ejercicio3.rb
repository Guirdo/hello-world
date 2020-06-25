array1=[]
array2=[]

10.times do |j|
    puts "Arreglo #1, elemento ##{j+1}: "
    array1[j]=gets.chomp.to_i
end

puts "Siguiente array..."

10.times do |j|
    puts "Arreglo #2, elemento ##{j+1}: "
    array2[j]=gets.chomp.to_i
end

array_suma = []

10.times do |i|
    array_suma[i]=array1[i]+array2[i]
end

puts "La suma de cada elemento es: #{array_suma}"
