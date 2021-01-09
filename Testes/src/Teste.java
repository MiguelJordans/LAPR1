import org.la4j.matrix.DenseMatrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;
import org.la4j.Matrix;
/**

 *

 * @author cferreira

 */

public class Teste {


    /**

     * @param args the command line arguments

     */

            public static void main(String[] args) {

                double matComparacao[][]={{1, 0},{2,0}};

                // Criar objeto do tipo Matriz

                Matrix a = new Basic2DMatrix(matComparacao);



                //Obtem valores e vetores próprios fazendo "Eigen Decomposition"

                EigenDecompositor eigenD=new EigenDecompositor(a);

                Matrix [] mattD= eigenD.decompose();



                for(int i=0; i<2;i++)

                {

                    System.out.println(mattD[i]);

                }



                // converte objeto Matrix (duas matrizes)  para array Java

                double matA [][]= mattD[0].toDenseMatrix().toArray();

                double matB [][]= mattD[1].toDenseMatrix().toArray();





                for(int i=0; i<2;i++)

                {

                    for (int j=0; j<2; j++)

                        System.out.println(matA[i][j]);

                }







            }



        }

