package picture;

public class Main {


  public static void main(String[] args) {
    Process process = new Process(Utils.loadPicture(args[args.length - 2]));

    if (args[0] != null) {

      if (args[0].equals("invert")) {
        process.invert();
        Utils.savePicture(process.getPicture(), args[2]);
        System.out.println("picture invert saved :)");


      } else if (args[0].equals(("blur"))) {
        process.blur();
        Utils.savePicture(process.getPicture(), args[2]);
        System.out.println("picture blur saved :)");


      } else if (args[0].equals("grayscale")) {
        process.grayscale();
        Utils.savePicture(process.getPicture(), args[2]);
        System.out.println("picture grayscale saved :)");



      } else if (args[0].equals("rotate")) {
        if (args[1].equals("90")) {
          process.rotate90();
        } else if (args[1].equals("180")) {
          process.rotate180();
        } else if (args[1].equals("270")) {
          process.rotate270();
        }
        Picture changed = process.getPicture();
        Utils.savePicture(changed, args[3]);
        System.out.println("picture rotated saved :)");


      } else if (args[0].equals("flip")) {

        if (args[1].equals("V")) {
          process.flipVertical();
        } else if (args[1].equals("H")) {
          process.flipHorizontal();
        }
        Picture changed = process.getPicture();
        Utils.savePicture(changed, args[3]);
        System.out.println("picture flip saved :)");

      }
      System.out.println();
    }
  }
}

