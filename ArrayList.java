public class ArrayList{
    Object[] masterArray = null;
    int arrayLength = 0;

    public ArrayList(){
        this.masterArray = new Object[0];
        this.arrayLength = 0;
    }

    /** insert()
    ------------------------
    requirements: index is within the bounds of the array
    end result: newObject is inserted into the array at the given index. All objects right of the index are pushed one right to make room.
    other important info: uses checkIndex()
     */
    public void insert(Object newObject, int index){

        this.arrayLength = arrayLength + 1;
        index = checkIndex(index);
        Object[] tempArray = new Object[arrayLength];
        //Copying over values from the old array to the new array until it reaches the position that needs to have newObject added to it
        for(int i = 0 ; i<index ; i++){
            tempArray[i] = masterArray[i];
        }
        //Inserting the new Object
        tempArray[index] = newObject;
        //Continuing to copy over the old objects, right of the insertion
        for(int i = index; i<arrayLength-1 ; i++){
            tempArray[i+1] = masterArray[i];
        }
        this.masterArray = tempArray;
    }

    //returns a valid index, if the index provided is already valid it just returns that
    public int checkIndex(int index){
        if(index<0){

            System.out.println("This position is outside the array. It has been changed to 0.");
            return 0;
        }
        if(index>=arrayLength){

            System.out.println("This position is outside the array. It has been changed to "+(arrayLength-1)+".");
            return arrayLength-1;
        }
        return index;
    }

    /** remove()
    ------------------------
    requirements: index is within the bounds of the array and the array is not empty
    end result: the object at position index is removed from the array, all points right of it shift left one, and the removed object is returned
    other important info: uses checkIndex()
     */
    public Object remove(int index){
        if(isEmpty()){
            System.out.println("ArrayList is already empty, nothing more can be removed");
            return null;
        }

        index = checkIndex(index);
        this.arrayLength = arrayLength - 1;
        Object tempObject = masterArray[index];
        Object[] tempArray = new Object[arrayLength];
        for(int i = 0 ; i<index ; i++){
            tempArray[i] = masterArray[i];
        }

        for(int i = index; i<arrayLength ; i++){
            tempArray[i] = masterArray[i+1];
        }
        this.masterArray = tempArray;

        return tempObject;
    }

    public int size(){
        return this.arrayLength;
    }

    @Override
    public String toString(){
        String returnString = "";
        //For loop adds every object onto the String, as well as a comma and a space
        for(int i = 0; i<arrayLength ; i++){
            returnString = returnString+masterArray[i]+", \n";
        }
        //substring to remove the last comma and space
        returnString = returnString.substring(0, returnString.length()-2);
        return returnString;
    }

    public boolean isEmpty(){
        if(masterArray.length == 0){
            return true;
        }
        return false;
    }

    public int indexOfObject(Object findObject){
        //checking every position in the array against findObject, if it matches one of them the index is returned, else -1 is returned
        for(int i = 0; i<arrayLength ; i++){
            if(masterArray[i].equals(findObject)){
                return i;
            }
        }
        return -1;
    }

    /** equals
    ------------------------
    requirements: none
    end result: returns true if the objects equal, otherwise false
    other important info: none
     */

    public boolean equals(ArrayList that){
        //checks lengths
        if(this.arrayLength != that.arrayLength){
            return false;
        }
        //checks each object against the corresponding object
        for(int i = 0; i<this.arrayLength ; i++){
            if(this.get(i) != that.get(i)){
                return false;
            }
        }
        return true;
    }

    public Object get(int index){
        return masterArray[index];
    }
}