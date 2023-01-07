public enum ExtendedOperation implements Operation{

    EXP{
        @Override
        public double apply(double x, double y) {
            return Math.pow(x,y);
        }
    },
    REMAINDER{
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };
}
