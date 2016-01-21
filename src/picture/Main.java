package picture;

public class Main {


  public static void main(String[] args) {
    Process process = new Process(Utils.loadPicture(args[args.length - 2]));

    if (args[0] != null) {

      if (args[0].equals("invert")) {
       // process = new Process(Utils.loadPicture(args[1]));
        process.invert();
        //Picture changed = process.getPicture();
        Utils.savePicture(process.getPicture(), args[2]);
        System.out.println("picture invert saved :)");


      } else if (args[0].equals(("blur"))) {
        //process = new Process(Utils.loadPicture(args[1]));
        process.blur();
        //Picture changed = process.getPicture();
        Utils.savePicture(process.getPicture(), args[2]);
        System.out.println("picture blur saved :)");


      } else if (args[0].equals("grayscale")) {
        //process = new Process(Utils.loadPicture(args[1]));
        process.grayscale();
        //Picture changed = process.getPicture();
        Utils.savePicture(process.getPicture(), args[2]);
        System.out.println("picture grayscale saved :)");



      } else if (args[0].equals("rotate")) {
        //process = new Process(Utils.loadPicture(args[2]));
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
        //process = new Process(Utils.loadPicture(args[2]));

        if (args[1].equals("V")) {
          process.flipVertical();
        } else if (args[1].equals("H")) {
          process.flipHorizontal();
        }
        Picture changed = process.getPicture();
        Utils.savePicture(changed, args[3]);
        System.out.println("picture flip saved :)");

      }
      //Picture pictureNew = Utils.savePicture(picture.getImage(), args[0].length() - 1);
      System.out.println();

    }
  }
}

