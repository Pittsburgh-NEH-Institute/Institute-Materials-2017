# Visualization formats

## Image formats

The web is capable of delivering many types of image files most of which are *raster* images. A raster image is a pixel-by-pixel representation of the visual image. Raster images are easy to create (just copy the pixel pattern), and they’re the most common way of representing photographs (including manuscript facsimiles), screen shots, and images in general.

## Raster formats

TIFF
JPG
PNG
GIF

## Conversion and the Imagemagick toolkit

The Imagemagick home is <https://www.imagemagick.org/script/index.php>. The tools you need are:

* [identify](https://www.imagemagick.org/script/identify.php): get information about an image (more detailed than the `file` command)
* [convert](https://www.imagemagick.org/script/convert.php): change image type and format

Common conversions are not only among basic formats (e.g., PNG vs JPG), but also size (horizontal and vertical pixel counts) and color depth (more colors = better appearance by larger file). To convert a 32-bit PNG to an 8-bit one, for example, a common compromise between quality and file size:

```bash
convert original.png -resize 1024x768 - quality 95 PNG8:new.png
```

This specifies that the image will measure 1024 pixels horizontally by 768 vertically (the 4 x 3 ratio is common), 95% of the quality will be retained (sacrificing a small amount of detail for reduced file size), and the color depth will be 8-bit color (256 different colors). 

## Image editing

### Raster images

GIMP, PhotoShop

### SVG

Inkscape

## Why SVG is special

### SVG and the DOM

### SVG and JavaScript

## HTML image maps