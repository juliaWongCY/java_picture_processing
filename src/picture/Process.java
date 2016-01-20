package picture;


public class Process {

  private Picture pic;

  public Picture getPicture(){
    return pic;
  }

    public Process(Picture pic){

      this.pic = pic;
  }

  public void invert(){
    int h = pic.getHeight();
    int w =  pic.getWidth();
    Picture invertPic = Utils.createPicture(w,h);
    for (int x = 0; x < pic.getWidth(); x++) {
      for (int y = 0; y < pic.getHeight(); y++) {

        Color colorI = pic.getPixel(x, y);
        colorI = new Color(255 - colorI.getRed(),255 - colorI.getGreen(), 255 - colorI.getBlue());
        invertPic.setPixel(x, y, colorI);

        }

      }
    pic = invertPic;
  }

    public void grayscale(){
      int h = pic.getHeight();
      int w =  pic.getWidth();
      Picture grayPic = Utils.createPicture(w,h);
      for (int x = 0; x < w; x++) {
        for (int y = 0; y < h; y++) {
        int red = pic.getPixel(x, y).getRed();
        int green = pic.getPixel(x, y).getGreen();
        int blue = pic.getPixel(x, y).getBlue();
        int avg = (red + green + blue)/3;
        pic.getPixel(x, y).setRed(avg);
        pic.getPixel(x, y).setGreen(avg);
        pic.getPixel(x, y).setBlue(avg);
        grayPic.setPixel(x, y, pic.getPixel(x, y));

        }

      }
      pic = grayPic;

    }
    public void rotate90(){
      int width = pic.getHeight();
      int height = pic.getWidth();
      Picture rotated90pic = Utils.createPicture(height, width);
        for (int x = 0; x < width; x++) {
          for (int y = 0; y < height; y++) {
            rotated90pic.setPixel(y, height - 1 - x, pic.getPixel(x,y));
            }
        }
     pic = rotated90pic;
    }
    public void rotate180(){
      int widthN = pic.getWidth();
      int heightN = pic.getHeight();
      Picture rotated180pic = Utils.createPicture(widthN, heightN);

      for (int x = 0; x < widthN; x++) {
        for (int y = 0; y < heightN; y++) {
          rotated180pic.setPixel(widthN - 1 - x, heightN - 1 , pic.getPixel(x,y));
        }
      }
      pic = rotated180pic;

    }
    public void rotate270(){
      int widthN = pic.getHeight();
      int heightN = pic.getWidth();
      Picture rotated270pic = Utils.createPicture(heightN, widthN);

      for (int x = 0; x < widthN; x++) {
        for (int y = 0; y < heightN; y++) {
          rotated270pic.setPixel(widthN - 1, heightN - 1 - x , pic.getPixel(x,y));
        }
      }
      pic = rotated270pic;


    }
    public void flipHorizontal(){
      int widthN = pic.getWidth();
      int heightN = pic.getHeight();
      Picture flipH = Utils.createPicture(widthN, heightN);

      for (int x = 0; x < widthN; x++) {
        for (int y = 0; y < heightN; y++) {
          flipH.setPixel(widthN - 1 - x, y, pic.getPixel(x,y));
        }
      }
      pic = flipH;

    }
    public void flipVertical() {
      int widthN = pic.getWidth();
      int heightN = pic.getHeight();
      Picture flipV = Utils.createPicture(widthN, heightN);
      for (int x = 0; x < widthN; x++) {
        for (int y = 0; y < heightN; y++) {
          flipV.setPixel(x, heightN - 1 - y, pic.getPixel(x, y));
        }
        pic = flipV;

      }
    }
    public void blur(){
      // USE CONTAIN from Picture!!!
      int height = pic.getHeight();
      int width =  pic.getWidth();
      Picture blurPic = Utils.createPicture(width,height);

      for (int x = 1; x < width - 1; x++) {
        for (int y = 1; y < height - 1; y++) {
          for (int i = x - 1; i < x + 1 ; i++) {
            for (int j = y - 1; j < y + 1; j++) {
              int r = pic.getPixel(i, j).getRed();
              int g = pic.getPixel(i, j).getGreen();
              int b = pic.getPixel(i, j).getBlue();
              int rN =+ r;
              int gN =+ g;
              int bN =+ b;
              int avgR = rN/9;
              int avgG = gN/9;
              int avgB = bN/9;
              pic.getPixel(x, y).setRed(avgR);
              pic.getPixel(x, y).setGreen(avgG);
              pic.getPixel(x, y).setBlue(avgB);

              blurPic.setPixel(x, y, pic.getPixel(x, y));

            }

          }

        }

      }
      pic = blurPic;

    }

}