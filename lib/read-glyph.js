
var fs = require('fs');

function readGlyph (fpath) {

  var chars = fs.readFileSync(fpath);
  var glyph = {
    w:   0,
    h:   0,
    x:   0,
    y:   0,
    buf: [[]]
  };

  chars.forEach(function (ch, pos) {
    if (0x0a === ch) {
      glyph.h += 1;
      glyph.y = glyph.h - 1;
      glyph.w = (glyph.x > glyph.w) ? glyph.x : glyph.w;
      glyph.x = 0;
      glyph.buf.push([]);
      return;
    }
    glyph.buf[glyph.y][glyph.x] = ch;
    glyph.x++;
  });

  return {
    width: glyph.w,
    height: glyph.h,
    charAt: function (x, y) {
      if (x < glyph.w && y < glyph.h) {
        return glyph.buf[y][x] || 0x20;
      } else {
        throw 'Request exceeds size of glyph';
      }
    }
  };
}

module.exports = readGlyph;
