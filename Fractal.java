public class Fractal {
    public static void usage(int n){ // Function for print the different versions of use cases.
        if(n==1){
            System.out.println("Usage Fractal Mandelbrot <minReal> <maxReal> <minImg> <maxImg> <iterations> | Fractal Julia <cReal> <cImg> <iterations>");
        }else if(n==2){
            System.out.println("Usage Fractal Mandelbrot <minReal> <maxReal> <minImg> <maxImg> <iterations>");
        }else if(n==3){
            System.out.println("Usage Fractal Julia <cReal> <cImg> <iterations>");
        }
        
    }
    public static void argumentChecker(double minRe, double maxRe, double minIm, double maxIm, int iter) {
        //Check the minimum imaginary and real values are less than maximum ones.
        if(minRe>maxRe | minIm>maxIm){
            System.out.println("Incorrect Arguments for region.");
            System.exit(0);
        }
        //check the number of iterations is greater than zero.
        if(iter < 0){
            System.out.println("Number of iterations must be positive.");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        //checking the relevant arguments.
        if(args.length==0){
            System.out.println("No arguments were given.");
            usage(1);
            System.exit(0);
        }
        if(args[0].toLowerCase().equals("mandelbrot")){
            double minRe = -1, maxRe = 1, minIm = -1, maxIm = 1; //Default values
            int iter = 1000;
            if(args.length==5){
                try{ //Try catch blocks for check invalid arguments.
                    minRe = Double.parseDouble(args[1]);
                    maxRe = Double.parseDouble(args[2]);
                    minIm = Double.parseDouble(args[3]);
                    maxIm = Double.parseDouble(args[4]);
                    argumentChecker(minRe, maxRe, minIm, maxIm, iter);
                    Mandelbrot.show(minRe, maxRe, minIm, maxIm, iter);
                }catch(Exception e){
                    System.out.println("Incorrect Input Type");
                    usage(2);
                    System.exit(0);
                }
            }else if(args.length==6){
                try{ //Try catch blocks for check invalid arguments.
                    minRe = Double.parseDouble(args[1]);
                    maxRe = Double.parseDouble(args[2]);
                    minIm = Double.parseDouble(args[3]);
                    maxIm = Double.parseDouble(args[4]);
                    iter = Integer.parseInt(args[5]);
                    argumentChecker(minRe, maxRe, minIm, maxIm, iter);
                    Mandelbrot.show(minRe, maxRe, minIm, maxIm, iter);
                }catch(Exception e){
                    System.out.println("Incorrect Input Type");
                    usage(2);
                    System.exit(0);
                }
            }else if(args.length==1){
                Mandelbrot.show(minRe, maxRe, minIm, maxIm, iter);
            }else{
                usage(2);
            }
        }else if(args[0].toLowerCase().equals("julia")){
            double z_re = -0.4, z_im = 0.6; //Default values
            int iter=1000;
            if(args.length==1){
                Julia.show(z_re, z_im, iter);
            }else if(args.length==3){
                try{ //Try catch blocks for check invalid arguments.
                    z_re = Double.parseDouble(args[1]);
                    z_im = Double.parseDouble(args[2]);
                    argumentChecker(0, 0, 0, 0, iter);
                    Julia.show(z_re, z_im, iter);
                }catch(Exception e){
                    System.out.println("Incorrect Input Type");
                    usage(3);
                    System.exit(0);
                }
            }else if(args.length==4){
                try{ //Try catch blocks for check invalid arguments.
                    z_re = Double.parseDouble(args[1]);
                    z_im = Double.parseDouble(args[2]);
                    iter = Integer.parseInt(args[3]);
                    argumentChecker(0, 0, 0, 0, iter);
                    Julia.show(z_re, z_im, iter);
                }catch(Exception e){
                    System.out.println("Incorrect Input Type");
                    usage(3);
                    System.exit(0);
                }
            }else{
                usage(3);
            }
        }
    }
}
