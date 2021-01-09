# To view in X:

# To print on a PostScript printer:

set term png
set output "Gnuplot/1.png"


set title "Modelo"
set xlabel "Geração"
set ylabel "Número Femeas"

set border 3
set tics nomirror
set grid


set ytics 25

set style line 1 \
    linecolor rgb '#000000' \
    linetype 1 linewidth 2 \
    pointtype 5 pointsize 1



# Plot
plot "Output\\Data.txt" title "Total" with linespoints linestyle 1,"Output\\1st_gen.txt" title "1st gen" with linespoints linestyle 2, "Output\\2nd_gen.txt" title "2nd gen" with linespoints linestyle 3,"Output\\3rd_gen.txt" title "3rd gen" with linespoints linestyle 4,"Output\\4th_gen.txt" title "4th gen" with linespoints linestyle 5