var readGlyph = require('../lib/read-glyph');
var isClosure = require('../lib/is-closure');

function expect (res, exp) {
  if (exp === res) {
    console.log('[PASS]');
  } else {
    console.log('[FAIL] expect ' + exp + ' while getting ' + res + '.');
  }
}

(function () {
  expect(isClosure(readGlyph('test/fixtures/line.ascii')), false);
  expect(isClosure(readGlyph('test/fixtures/rect.ascii')), true);
  expect(isClosure(readGlyph('test/fixtures/triangle.ascii')), true);
  expect(isClosure(readGlyph('test/fixtures/dog.ascii')), true);
})();
