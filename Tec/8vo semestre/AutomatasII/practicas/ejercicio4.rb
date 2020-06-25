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

array_mayor =[]

10.times do |i|
    if array1[i]>=array2[i]
        array_mayor[i] = array1[i]
    else
        array_mayor[i] = array2[i]
    end
end

puts "Los numeros mayores de cada array son: #{array_mayor}"