package picture;


public class Process {

  private Picture pic;


    public Process(Picture pic){

      this.pic = pic;
  }

  public Picture getPicture(){
    return pic;
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
      int width = pic.getWidth();
      int height = pic.getHeight();
      Picture rotated90pic = Utils.createPicture(height, width);
        for (int x = 0; x < width; x++) {
          for (int y = 0; y < height; y++) {
            rotated90pic.setPixel(height - 1 - y, x, pic.getPixel(x,y));
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
          rotated180pic.setPixel(widthN - 1 - x, heightN - 1 - y , pic.getPixel(x,y));
        }
      }
      pic = rotated180pic;
    }

    public void rotate270(){
      int height = pic.getHeight();
      int width = pic.getWidth();
      Picture rotated270pic = Utils.createPicture(height, width);

      for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
          rotated270pic.setPixel(y, width - 1 - x , pic.getPixel(x,y));
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
      }
      pic = flipV;
    }

    public void blur(){
    int height = pic.getHeight();
    int width =  pic.getWidth();
    Picture blurPic = Utils.createPicture(width,height);

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if(i == 0 || i == width - 1 || j == height - 1 || j == 0){
          Color boundary = pic.getPixel(i, j);
          blurPic.setPixel(i, j, boundary);
          } else {
          int rN = 0;
          int gN = 0;
          int bN = 0;
          for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
              int r = pic.getPixel(x, y).getRed();
              int g = pic.getPixel(x, y).getGreen();
              int b = pic.getPixel(x, y).getBlue();
              rN += r;
              gN += g;
              bN += b;

          }
        }

        int avgR = rN / 9;
        int avgG = gN / 9;
        int avgB = bN / 9;
        Color avg = new Color(avgR, avgG, avgB);
        blurPic.setPixel(i, j, avg);
      }
    }
  }
  pic = blurPic;

        }
      }


