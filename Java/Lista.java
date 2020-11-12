
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>Clase genérica para listas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas no aceptan a <code>null</code> como elemento.</p>
 *
 * @param <T> El tipo de los elementos de la lista.
 */
public class Lista<T> implements Coleccion<T> {

    /* Clase interna privada para nodos. */
    private class Nodo {
        /* El elemento del nodo. */
        public T elemento;
        /* El nodo anterior. */
        public Nodo anterior;
        /* El nodo siguiente. */
        public Nodo siguiente;

        /* Construye un nodo con un elemento. */
        public Nodo(T elemento) {
            this.elemento = elemento;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    /* Clase interna privada para iteradores. */
    private class Iterador implements IteradorLista<T> {
        /* El nodo anterior. */
        public Nodo anterior;
        /* El nodo siguiente. */
        public Nodo siguiente;

        /* Construye un nuevo iterador. */
        public Iterador() {
            this.anterior = null;
            this.siguiente = cabeza;
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override public boolean hasNext() {
            if(this.siguiente == null) {
                return false;
            } else {return true;}
        }

        /* Nos da el elemento siguiente. */
        @Override public T next() {
            if (siguiente == null){
                throw new NoSuchElementException("");
            }
            T el = siguiente.elemento;
            anterior = siguiente;
            siguiente = siguiente.siguiente;
            return el;
        }

        /* Nos dice si hay un elemento anterior. */
        @Override public boolean hasPrevious() {
            if(this.anterior == null) {
                return false;
            } else {return true;}
        }

        /* Nos da el elemento anterior. */
        @Override public T previous() {
            if (anterior == null){
                throw new NoSuchElementException("");
            }
            Nodo nodo = new Nodo(this.anterior.elemento);
            this.siguiente = this.anterior;
            this.anterior = this.anterior.anterior;

            return nodo.elemento;
        }

        /* Mueve el iterador al inicio de la lista. */
        @Override public void start() {
            this.anterior = null;
            this.siguiente = cabeza;
        }

        /* Mueve el iterador al final de la lista. */
        @Override public void end() {
            this.anterior = rabo;
            this.siguiente = null;
        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista. El método es idéntico a {@link
     * #getElementos}.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        int cont = 0;
        Iterator l = this.iterator();
        while (l.hasNext()){
            cont++;
            l.next();
        }
        this.longitud = cont;
        return cont;
    }

    /**
     * Regresa el número elementos en la lista. El método es idéntico a {@link
     * #getLongitud}.
     * @return el número elementos en la lista.
     */
    @Override public int getElementos() {
        return this.getLongitud();
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    @Override public boolean esVacia() {
        return this.rabo == null;
    }

    /**
     * Agrega un elemento a la lista. Si la lista no tiene elementos, el
     * elemento a agregar será el primero y último. El método es idéntico a
     * {@link #agregaFinal}.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    @Override public void agrega(T elemento) {
        Iterator l = this.iterator();
        if (elemento == null){throw new IllegalArgumentException("");}
        if (this.esVacia()) {
            this.cabeza = new Nodo(elemento);
            this.rabo = this.cabeza;
        } else {
            Nodo nodo = new Nodo(elemento);
            this.rabo.siguiente = nodo;
            nodo.anterior = this.rabo;
            this.rabo = nodo;
        }
        this.longitud += 1;

    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("");
        }
        agrega(elemento);
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(T elemento)
        if(elemento == null){
            throw new IllegalArgumentException("");
        }
        Nodo n = new Nodo(elemento);
        if (rabo == null) {
            cabeza = rabo = n;
        } else {
            cabeza.anterior = n;
            n.siguiente = cabeza;
            cabeza = n;
        }
        this.longitud++;
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * @param i el índice dónde insertar el elemento. Si es menor que 0 el
     *          elemento se agrega al inicio de la lista, y si es mayor o igual
     *          que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void inserta(int i, T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("");
        }
        Iterator l = this.iterator();
        int n = this.getLongitud();
        int cont = 0;
        if (i <= 0) {
            this.agregaInicio(elemento);
        } else if (n <= i) {
            this.agregaFinal(elemento);
        } else {
            Nodo nodo = this.cabeza;
            while (cont < i){
                nodo = nodo.siguiente;
                cont++;
            }
            Nodo nodo_nuevo = new Nodo(elemento);
            nodo_nuevo.siguiente = nodo;
            nodo_nuevo.anterior = nodo.anterior;
            nodo.anterior.siguiente = nodo_nuevo;
            nodo.anterior = nodo_nuevo;
        }
        this.longitud += 1;
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    @Override public void elimina(T elemento) {
        Nodo nodo = (buscaNodo(elemento));
        if (nodo != null) {
            reemplaza(nodo);
        }
    }
    public Nodo buscaNodo(T elemento) {
        Nodo nodo = this.cabeza;
        while(nodo != null){
            if (nodo.elemento.equals(elemento)){
                return nodo;
            } else {
                nodo = nodo.siguiente;
            }
        }
        return null;

    }
    public void reemplaza(Nodo elemento) {
        if (this.getLongitud() == 1){
            this.cabeza = null;
            this.rabo = null;
        } else if (elemento.equals(this.rabo)) {
            Nodo nodo = rabo.anterior;
            nodo.siguiente = null;
            rabo = nodo;
        } else if (elemento.equals(this.cabeza)) {
            Nodo nodo = cabeza.siguiente;
            nodo.anterior = null;
            cabeza = nodo;
        } else {
            Nodo nodo_ant = elemento.anterior;
            Nodo nodo_sig = elemento.siguiente;
            nodo_ant.siguiente = nodo_sig;
            nodo_sig.anterior = nodo_ant;
        }
        this.longitud -= 1;
    }

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() {
        if (this.esVacia()) {
            throw new NoSuchElementException("");
        }else if (this.longitud == 1){
            T cabeza_elemento = cabeza.elemento;
            rabo = null;
            cabeza = null;
            return cabeza_elemento;
        }
        T cabeza_elemento = this.cabeza.elemento;
        Nodo nodo_cabeza = this.cabeza;
        Nodo nodo = nodo_cabeza.siguiente;
        nodo.anterior = null;
        cabeza = nodo;
        this.longitud -= 1;
        return cabeza_elemento;
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaUltimo() {
        if (this.esVacia()) {
            throw new NoSuchElementException("");
        } else if (this.longitud == 1){
            T rabo_elemento = rabo.elemento;
            rabo = null;
            cabeza = null;
            return rabo_elemento;
        }
        T rabo_elemento = this.rabo.elemento;
        Nodo nodo_rabo = this.rabo;
        Nodo nodo = nodo_rabo.anterior;
        nodo.siguiente = null;
        rabo = nodo;
        this.longitud -= 1;
        return rabo_elemento;
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean contiene(T elemento) {
        return buscaNodo(elemento) != null;
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public Lista<T> reversa() {
        Iterator <T> l = this.iterator();
        Lista<T> lista = new Lista<T>();
        while (l.hasNext()){
            T el = l.next();
            lista.agregaInicio(el);
        }
        return lista;
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public Lista<T> copia() {
        Lista <T> lista = new Lista <T> ();
        Iterator <T> l = this.iterator();
        while (l.hasNext()) {
            lista.agregaFinal(l.next());
        }
        return lista;
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    @Override public void limpia() {
        this.cabeza = null;
        this.rabo = null;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getPrimero() {
        if (this.esVacia()) {
            throw new NoSuchElementException("");
        }
        return this.cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getUltimo() {
        if (this.esVacia()) {
            throw new NoSuchElementException("");
        }
        return this.rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public T get(int i) {
        if(i < 0 || this.longitud <= i){
            throw new ExcepcionIndiceInvalido("");
        }
        int cont = 0;
        Iterator <T> l = this.iterator();
        while (cont < i){
            l.next();
            cont++;
        }
        return l.next();
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(T elemento) {
        Nodo nodo = this.cabeza;
        int cont = 0;
        while (cont < this.longitud){
            if (nodo.elemento.equals(elemento)){
                return cont;
            } else {
                nodo = nodo.siguiente;
                cont++;
            }
        }
        return -1;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    @Override public String toString() {
        Iterator <T> l = this.iterator();
        if (this.cabeza == null){
            String lista = "[]";
            return lista;
        } else {
            String lista = String.format("[%s", l.next());
            while(l.hasNext()) {
                T el = l.next();
                lista += String.format(", %s", el);
            }
            lista += "]";
            return lista;
        }
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la lista es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        @SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>)objeto;
        Iterator <T> l = this.iterator();
        Iterator <T> ll = lista.iterator();
        if (this.longitud != lista.longitud){
            return false;
        }
        while (l.hasNext() || ll.hasNext()){
            if (!l.next().equals(ll.next())){
                return false;
            }
        }
        return true;
    }

    /**
     * Regresa un iterador para recorrer la lista en una dirección.
     * @return un iterador para recorrer la lista en una dirección.
     */
    @Override public Iterator<T> iterator() {
        return new Iterador();
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas direcciones.
     * @return un iterador para recorrer la lista en ambas direcciones.
     */
    public IteradorLista<T> iteradorLista() {
        return new Iterador();
    }
}
