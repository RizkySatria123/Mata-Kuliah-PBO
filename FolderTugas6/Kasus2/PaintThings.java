public class PaintThings {
    public static void main(String[] args) {
        Paint deckPaint = new Paint(350);

        Rectangle deck = new Rectangle(20, 35);
        Sphere bigBall = new Sphere(15);
        Cylinder tank = new Cylinder(10, 30);

        double deckAmt = deckPaint.amount(deck);
        double ballAmt = deckPaint.amount(bigBall);
        double tankAmt = deckPaint.amount(tank);

        System.out.printf("Amount of paint for %s: %.3f gallons%n", deck, deckAmt);
        System.out.printf("Amount of paint for %s: %.3f gallons%n", bigBall, ballAmt);
        System.out.printf("Amount of paint for %s: %.3f gallons%n", tank, tankAmt);
    }
}
