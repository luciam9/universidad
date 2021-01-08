package dataStructures.dictionary;
import dataStructures.list.List;

import dataStructures.list.ArrayList;
import dataStructures.set.AVLSet;
import dataStructures.set.Set;
import dataStructures.tuple.Tuple2;

/**
 * Estructuras de Datos. Grados en Informatica. UMA.
 * Examen de septiembre de 2018.
 *
 * Apellidos, Nombre:
 * Titulacion, Grupo:
 */
public class HashBiDictionary<K,V> implements BiDictionary<K,V>{

	private Dictionary<K,V> bKeys;
	private Dictionary<V,K> bValues;
	
	public HashBiDictionary() {

		bKeys = new HashDictionary<>();
		bValues = new HashDictionary<>();
	}
	
	public boolean isEmpty() {

		return bKeys.isEmpty() && bValues.isEmpty();
	}
	
	public int size() {

		return bKeys.size();
	}
	
	public void insert(K k, V v) {

		if(bKeys.isDefinedAt(k)){

			bKeys.delete(k);
			bKeys.insert(k, v);
			bValues.delete(v);
			bValues.insert(v, k);

		}else{
			bKeys.insert(k, v);
			bValues.insert(v, k);
		}
	}
	
	public V valueOf(K k) {

		if(bKeys.isDefinedAt(k)){

			return bKeys.valueOf(k);

		}else{

			return null;
		}

	}
	
	public K keyOf(V v) {

		if(bValues.isDefinedAt(v)){

			return bValues.valueOf(v);
		}
		return null;
	}
	
	public boolean isDefinedKeyAt(K k) {
		return bKeys.isDefinedAt(k);
	}
	
	public boolean isDefinedValueAt(V v) {
		return bValues.isDefinedAt(v);
	}
	
	public void deleteByKey(K k) {
		// TODO
	}
	
	public void deleteByValue(V v) {
		// TODO
	}
	
	public Iterable<K> keys() {
		return bKeys.keys();
	}
	
	public Iterable<V> values() {
		return bValues.keys();
	}
	
	public Iterable<Tuple2<K, V>> keysValues() {
		return bKeys.keysValues();
	}
	
		
	public static <K,V extends Comparable<? super V>> BiDictionary<K, V> toBiDictionary(Dictionary<K,V> dict) {

		Set <V> setValues = new AVLSet<>();
		boolean inyectivo = false;

		for (V value: dict.values()) {
			if (setValues.isElem(value)) {
				inyectivo = true;
				break;
			} else {
				setValues.insert(value);
			}
		}

		if(inyectivo){

			HashBiDictionary<K, V> bidict = new HashBiDictionary<>();

			for(Tuple2<K, V> tupla : dict.keysValues()){

				bidict.insert(tupla._1(), tupla._2());
			}
		}else{

			throw new IllegalArgumentException("El diccionario no es inyectivo");
		}

	}
	
	public <W> BiDictionary<K, W> compose(BiDictionary<V,W> bdic) {

		BiDictionary<K, W> dict = new HashBiDictionary<>();

		for(K key : bKeys.keys()){

			V value = bKeys.valueOf(key);

			if(bdic.isDefinedKeyAt(value)){

				dict.insert(key, bdic.valueOf(value));
			}
		}

		return dict;
	}
		
	public static <K extends Comparable<? super K>> boolean isPermutation(BiDictionary<K,K> bd) {

		
	}
	
	// Solo alumnos con evaluaci�n por examen final.
    // =====================================
	
	public static <K extends Comparable<? super K>> List<K> orbitOf(K k, BiDictionary<K,K> bd) {
		// TODO
		return null;
	}
	
	public static <K extends Comparable<? super K>> List<List<K>> cyclesOf(BiDictionary<K,K> bd) {
		// TODO
		return null;
	}

    // =====================================
	
	
	@Override
	public String toString() {
		return "HashBiDictionary [bKeys=" + bKeys + ", bValues=" + bValues + "]";
	}
	
	
}
