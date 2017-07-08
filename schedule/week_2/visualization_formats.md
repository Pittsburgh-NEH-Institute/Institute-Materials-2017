# Visualization file formats

## Image formats

A *raster* image is a pixel-by-pixel representation of a visual image. Common raster formats include [TIFF](https://en.wikipedia.org/wiki/TIFF), [JPG](https://en.wikipedia.org/wiki/JPEG), [PNG](https://en.wikipedia.org/wiki/Portable_Network_Graphics), and [GIF](https://en.wikipedia.org/wiki/GIF). Raster images are easy to create (at a certain level, they just copy the pixel pattern of the source), and they’re the most common way of representing photographs (including manuscript facsimiles), screen shots, and images in general. Raster images look best at their original size or smaller; when they are expanded, the expansion doesn’t add pixels, which means that the pixels just grow fatter. A image that has become blocky, with visible stair steps instead of smooth diagonals, is described as *pixelated*.

A *vector* image describes the contours of the image. For example, where a raster image might describe a short diagonal as “color the pixels at positions 0,0; 1,1; 2,2; and 3,3” a vector image says “draw a line from 0,0 to 3,3”. Vector images are *scalable*; when you blow them up, they retain their smooth diagonals because they can create new pixels instead of just fattening the existing ones. The only vector format in broad use on the Web is [SVG](http://tutorials.jenkov.com/svg/index.html) (Scalable Vector Graphics). 

The size of raster image files depends ultimately on the number of pixels (although not in a linear way, since many image formats are compressed), so larger, more detailed images make for larger file sizes (and slower download times). The size of vector image files depends on their complexity; an instruction to draw a long line takes no more space than an instruction to draw a short line, but (although there are optimization simplifications here, too) each vector shape requires an additional instruction.

Unless you have good reason to do otherwise, use raster images for photographs, including screen captures, which typically have a lot of detail, many colors or shades, and few regular geometric shapes. Use SVG for charts and graphs, which have less detail, fewer colors or shades, and more regular geometric shapes. Additionally, as is explained below, it is easier for users to interact with the parts of an SVG image than with parts of a raster image.

## Raster formats

Raster file formats may be compressed, and the compression is either *lossless* (compression reduces the file size without throwing away information) or *lossy* (compression is achieved by throwing away infomation that is not easily noticed by the human eye). All other things being equal, lossy compression (not surprisingly) typically produces smaller but less detailed images than lossless compression.

The most common raster formats are:

* **TIFF** (Tagged Image File Format). Common for archival use because it provides a high degree of fidelity. Uncommon for Web use because file sizes are typically larger than with other formats. Filename extensions are `.tif` or `.tiff`.
* **JPG** (Joint Photographic Experts Group). Common for web use because of relatively small file size. The filesize is achieved with lossy compression that can be adjusted by the developer, and that, in the best cases, is not noticable by the viewer. No support for transparent backgrounds. Filename extensions are `.jpg` and `.jpeg`.
* **PNG** (Portable Network Graphics). PNG24 is a widely used lossless file format; PNG8 is limited to 256 colors. Supports transparent backgrounds. Does not support standard EXIF metadata. Filename extension is `.png`.
* **GIF** (Graphics Interchange Format). Limited to 256 colors. Supports transparent backgrounds. Does not support standard EXIF metadata. Has largely been replaced by PNG. Filename extension is `.gif`.

For a comparison of raster format features, see [GIF, PNG, JPG or SVG. Which One To Use?](https://www.sitepoint.com/gif-png-jpg-which-one-to-use/).
 
## Conversion and the Imagemagick toolkit

You can convert images from one format to another at the command line with the open source, platform independent Imagemagick toolkit, located at <https://www.imagemagick.org/script/index.php>. The Imagemagick tools we use most often are:

* [identify](https://www.imagemagick.org/script/identify.php): get information about an image (more detailed than the `file` command, especially with the `-verbose` switch)
* [convert](https://www.imagemagick.org/script/convert.php): change image type and format

Common conversions are not only among basic formats (e.g., PNG vs JPG), but also size (horizontal and vertical pixel counts), color depth (fewer colors = smaller file, although the difference in appearance may be noticeable), and the declaration of a transparent (background) color (to make the image blend into a colored page background, instead of being framed by a [typically white] square).

As a rule of thumb, blowing up raster images is not recommended because it will cause them to become pixelated. If you reduce the size of an excessively large image, a reasonable target is 1600px on the horizontal dimension. Dots per inch (dpi) and pixels per inch (ppi) are not meaningful for web publication, but they do matter for print. You can resize the way an image is rendered on a web page by setting the `@width` or `@height` attributes of the `<img>` element, but if your image is larger than it needs to be, reducing the image itself by transforming the file is a better strategy because smaller image files enable the web page to load more quickly. 

For more information about choosing a raster image format see Ilya Grigorik’s [Image optimization](https://developers.google.com/web/fundamentals/performance/optimizing-content-efficiency/image-optimization).

## Why SVG is special

SVG (Scalable Vector Graphics) is a [W3C standard](https://www.w3.org/TR/SVG11/) for vector images on the Web. The Mozilla Development Network [SVG portal](https://developer.mozilla.org/en-US/docs/Web/SVG) is a good source for reliable tutorial and reference information.

As described above, vector images (at least for charts and graphs, which typically have a lot of simple geometric shapes) are usually smaller than raster images, and they are equally crisp at any resolution. That makes them uniquely suited to Web delivery, which may land on screens that range from old, small, low-resolution phones to modern, large, high-resolution desktops.

### SVG, DOM, and JavaScript

SVG is XML under the hood, which means that when you embed an SVG image in a Web page, it forms part of the same in-memory tree (DOM, Document Object Model) as the textual content. This means that SVG can respond to mouseover, click, and other page events. No other image format has comparable support for dynamic, interactive web delivery. Furthermore, SVG charts and graphs that represent information about your edition can be generated programmatically (and even dynamically) from your textual XML, which gives SVG unique user-oriented capabilities in the context of an interactive site. 

For reasons of file size and scalability, SVG is the format of choice for charts and graphs that are embedded in a web page, and it is uniquely capable in situations where the images need to respond to user-initiated events. For a small illustration of simple interactive SVG within a web page, see <http://dh.obdurodon.org/election.xhtml>; view the source of the page to see how it works.

## HTML image maps

Image maps are an HTML technology for turning portions of a raster image into hot spots that respond to user-generated clicks. Interactivity is more limited with HTML image maps than with SVG, but an image map may be an effective way to adding interactivity to zones of raster images. Image map locations are specified in pixels, which are easiest to calculate with the help of a tool like Dario D. Müller’s online [Easy imagemap generator](http://imagemap-generator.dariodomi.de/). For a minimal working example of an image map, see the w3schools.com [HTML \<map\> Tag](https://www.w3schools.com/tags/tag_map.asp) documentation.

## Image editing tools

### Raster images

The most popular free, open source, platform independent image editing toolkit is [GIMP](https://www.gimp.org/). The commercial, industry-standard tool (Windows and Mac OS only) is [Adobe PhotoShop](http://www.adobe.com/products/photoshop.html).

### SVG

The most popular free, open source, platform independent SVG editing tool is [Inkscape](https://inkscape.org/en/).

## Drawing graphs

The most popular free, open source, platform independent tool for drawing graphs is [graphviz](http://www.graphviz.org/). A commercial alternative for Mac OS is [Omnigraffle](https://www.omnigroup.com/omnigraffle). A free online alternative is [draw.io](https://www.draw.io/).

