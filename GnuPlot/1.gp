# To view in X:

# To print on a PostScript printer:

set timefmt '%Y-%m-%d %H:%M:%S'

set term png
set output "%y-%m-%d-%H-%M.png"


set title "Modelo"
set xlabel "X"
set ylabel "Y"

set style data linespoints

f(x) = 2 * sin(x)
g(x) = 2 * cos(x)

# Plot
plot f(x) title 'sin(x)' with lines linestyle 1, \
     g(x) title 'cos(x)' with lines linestyle 2
