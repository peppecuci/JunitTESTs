package be.digitalcity.tu;

public class Triangle {

    private final Integer side1;
    private final Integer side2;
    private final Integer side3;


    //region const-get-set
    public Triangle(Integer side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Integer getSide1() {
        return side1;
    }

    public Integer getSide2() {
        return side2;
    }

    public Integer getSide3() {
        return side3;
    }
    //endregion


    //

    public void checkValidity() throws TriangleExceptions {

        if(side1 == 0 || side2 == 0 || side3 == 0) throw new TriangleExceptions("ATTENTION! Ceci n'est pas un triangle #MAGRITTE car une valeur zero a été introudite");
        else if (side1 == null || side2 == null || side3 == null) throw new TriangleExceptions("Ceci n'est pas un triangle #MAGRITTE car une valeur null a été introduite");
        if (    ((side1 + side2) < side3) ||
                ((side1 + side3) < side2) ||
                ((side2 + side3) < side1)
        ) throw new TriangleExceptions("ATTENTION! Ceci n'est pas un triangle #MAGRITTE car la somme de deux triangle n'est pas toujours plus grand que le troisieme triangle");

        //VERIF SI TRIANGLE EST ISOSCELE
        if (    (side1.equals(side2) && !side1.equals(side3)) ||
                (side1.equals(side3) && !side1.equals(side2)) ||
                (side2.equals(side3) && !side2.equals(side1)) ||
                (side3.equals(side2) && !side3.equals(side1))
        )
        {System.out.println("Isosceles Triangle");}

        //VERIF SI TRIANGLE EST EQUILATERAL
        else if (side1.equals(side2) && side1.equals(side3)) {

            System.out.println("Equilateral Triangle");

        }

        //VERIF SI TRIANGLE EST SCALENE
        else if (!side1.equals(side2) && !side2.equals(side3)) {

            System.out.println("Scalene Triangle");

        }

    }

}
