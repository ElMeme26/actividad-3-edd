public class SubsetSum {
    
    public static boolean hasSubsetSum(int[] set, int target) {
        return subsetSumRecursive(set, target, 0);
    }

    private static boolean subsetSumRecursive(int[] set, int target, int index) {
        // Caso base: objetivo alcanzado
        if (target == 0) {
            return true;
        }
        // Caso base: no hay más elementos o objetivo negativo
        if (index >= set.length || target < 0) {
            return false;
        }
        // Incluir el elemento actual o excluirlo
        return subsetSumRecursive(set, target - set[index], index + 1) ||
               subsetSumRecursive(set, target, index + 1);
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int target = 9;

        for (int i = 0; i < set.length; i++) {
            System.out.print(i + " ");
        }
        
        System.out.println("\n¿Existe subconjunto que sume " + target + "? " + hasSubsetSum(set, target));

        target = 30;
        System.out.println("¿Existe subconjunto que sume " + target + "? " + hasSubsetSum(set, target));
    }
}