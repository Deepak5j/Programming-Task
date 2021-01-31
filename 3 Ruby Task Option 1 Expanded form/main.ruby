def expanded_form(num)
  num.digits.each_with_index.map do |val, i|
    if (val > 0)
      val * (10 ** i)
    end
  end.compact.reverse.join(' + ')
end

number = gets.chomp.to_i

puts expanded_form(number)