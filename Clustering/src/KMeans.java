/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User-pc
 */

import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import cern.colt.matrix.impl.SparseDoubleMatrix2D;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomGenerator;


public class KMeans {

   private DoubleMatrix2D means;
   private DoubleMatrix2D partition;
   private int maxIterations = 1000;
   private RandomGenerator randomGenerator = new MersenneTwister();
   private PartitionGenerator partitionGenerator = new HardRandomPartitionGenerator();
//   private VectorVectorFunction distanceMeasure = Statistic.EUCLID;
   private CosineDistance distanceMeasure = new CosineDistance();
   private DoubleMatrix2D data;
   private DoubleMatrix2D SV;
   int totalIterations;
   int clusters;
   double distance = 0;
   long output;

   
   public KMeans(DoubleMatrix2D data, int clusters) {
       this.data = data;
       this.clusters = clusters;
   }

    public KMeans(DoubleMatrix2D data, DoubleMatrix2D SV, int clusters) {
       this.data = data;
       this.SV = SV;
       this.clusters = clusters;
   }
   
   public void cluster() {
      long lStartTime = System.currentTimeMillis();
      int n = data.rows(); // Number of features
      int p = data.columns(); // Dimensions of features

      partition = new SparseDoubleMatrix2D(n, clusters);
      partitionGenerator.setRandomGenerator(randomGenerator);
      partitionGenerator.generate(partition);

      means = new DenseDoubleMatrix2D(p, clusters);

      boolean changedPartition = true;

      // Begin the main loop of alternating optimization
      for (int itr = 0; itr < maxIterations && changedPartition; ++itr) {
         // Get new prototypes (v) for each cluster using weighted median
         for (int k = 0; k < clusters; k++) {

            for (int j = 0; j < p; j++) {
               double sumWeight = 0;
               double sumValue = 0;

               for (int i = 0; i < n; i++) {
                  double Um = partition.getQuick(i, k);
                  sumWeight += Um;
                  sumValue += data.getQuick(i, j) * Um;
               }

               means.setQuick(j, k, sumValue / sumWeight);
            }
         }

         // Calculate distance measure d:
         DoubleMatrix2D distances = new DenseDoubleMatrix2D(n, clusters);
         for (int k = 0; k < clusters; k++) {
            for (int i = 0; i < n; i++) {
               // Euclidean distance calculation
               if(SV != null){
                    distance = distanceMeasure.calculateDistance(means.viewColumn(k), SV.viewRow(i));
               }else{
                   distance = distanceMeasure.calculateDistance(means.viewColumn(k), data.viewRow(i));
               }
               distances.setQuick(i, k, distance);
            }
         }

         // Get new partition matrix U:
         changedPartition = false;
         for (int i = 0; i < n; i++) {
            double minDistance = Double.MAX_VALUE;
            int closestCluster = 0;

            for (int k = 0; k < clusters; k++) {
               // U = 1 for the closest prototype
               // U = 0 otherwise

               if (distances.getQuick(i, k) < minDistance) {
                  minDistance = distances.getQuick(i, k);
                  closestCluster = k;
               }
            }

            if (partition.getQuick(i, closestCluster) == 0) {
               changedPartition = true;

               for (int k = 0; k < clusters; k++) {
                  partition.setQuick(i, k, (k == closestCluster) ? 1 : 0);
               }
            }
         }
         totalIterations = itr;
      }
        long lEndTime = System.currentTimeMillis();

        output = lEndTime - lStartTime;
   }

   public DoubleMatrix2D getMeans() {
      return means;
   }

   public DoubleMatrix2D getPartition() {
      return partition;
   }
   
   public double getExecTime(){
       return (double) output/1000;
   }
   
   public int getTotalIterations(){
       return totalIterations+1;
   }

   public int getMaxIterations() {
      return maxIterations;
   }

   public void setMaxIterations(int maxIterations) {
      this.maxIterations = maxIterations;
   }

   public RandomGenerator getRandomGenerator() {
      return randomGenerator;
   }

   public void setRandomGenerator(RandomGenerator random) {
      this.randomGenerator = random;
   }

}
