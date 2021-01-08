# To view in X:

# To print on a PostScript printer:

set term png
set output "Gnuplot/1.png"


set title "Modelo"
set xlabel "Geração"
set ylabel "Número total de Femeas"

set border 3
set tics nomirror

set style data linespoints



# Plot
plot "Output\\Data.txt" title "Evolução de nº de Femeas" with linespoints