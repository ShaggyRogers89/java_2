package HW2;

public class Main {
    public static void main(String[] args) {

        String[][] myArray = {
                {"2", "3", "4", "5"},
                {"2", "3", "4", "5"},
                {"2", "3", "4", "5"},
                {"2", "3", "4", "5"}
        };

        try {
            getArray(myArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    static class MyArraySizeException extends Exception {
        MyArraySizeException(String msg) {
            super(msg);
        }
    }

    static class MyArrayDataException extends Exception {
        MyArrayDataException(String msg) {
            super(msg);
        }
    }

    static void getArray(String[][] myArray) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        if (myArray.length != 4) {
            throw new MyArraySizeException("Array's length is not correct");
        }

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].length != 4) {
                throw new MyArraySizeException("Array's length is not correct");
            }
            for (int j = 0; j < myArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(myArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Unable to convert cell [" + i + "][" + j + "]");
                }
            }
        }

        System.out.println("Array's summ is: " + sum);
    }
}
