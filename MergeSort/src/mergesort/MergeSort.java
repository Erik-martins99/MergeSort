package mergesort;

//import java.util.Arrays;
// import java.lang.reflect.Array;

public class MergeSort {

    public static void main(String[] args) {
        
        int []vet = {4, 5, 7, 1, 3, 8, 2, 9};
        int []aux = new int[vet.length];
        
        mergeSort(vet, aux, 0, vet.length-1);
        
        //System.out.println(Arrays.toString(vet));
        System.out.println("Vetor: ");
        for(int i=0; i<vet.length; i++){
            System.out.print(vet[i]+" ");
        }
    }

    private static void mergeSort(int[] vet, int[] aux, int inicio, int fim) {
        if(inicio < fim){
            
            int meio = (inicio + fim)/2;
            mergeSort(vet, aux, inicio, meio);
            mergeSort(vet, aux, meio+1, fim);
            intercalar(vet, aux, inicio, meio, fim);
        }
        
    }

    private static void intercalar(int[] vet, int[] aux, int inicio, int meio, int fim) {
        for(int i=inicio; i<=fim ; i++){
            aux[i] = vet[i];
        }
        
        int esq = inicio;
        int dir = meio + 1;
        
        for(int i=inicio; i<=fim; i++){
            if(esq > meio){
                vet[i]= aux[dir++];
            }
            else if(dir > fim){
                vet[i] = aux[esq++];
            }
            else if(aux[esq] < aux[dir]){
                vet[i]= aux[esq++];             
            }else{
                vet[i]= aux[dir++];
            }
        }
    }
    
}
