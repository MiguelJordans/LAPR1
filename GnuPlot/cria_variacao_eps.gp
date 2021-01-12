
set term postscript
set output "Gnuplot/variacao_tmp.eps"


set title "Modelo"
set xlabel "Geração"
set ylabel "variacao"

set border 3
set tics nomirror
set grid


set style line 1 \
    linecolor rgb '#000000' \
    linetype 1 linewidth 2 \
    pointtype 7 pointsize 1

set ytics 0.2
plot "Output\\variacao.txt" title "Variacao" with linespoints linestyle 1

