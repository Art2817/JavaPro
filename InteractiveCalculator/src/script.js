const d = document.getElementById('d');

function f(v) {
  if (v === 'C') d.value = '';
  else if (v === 'B') d.value = d.value.slice(0, -1);
  else if (v === '=') {
    try {
      if (d.value.includes('/0'))
        throw 'Zero';
      d.value = eval(d.value);
    }
    catch {
      d.value = 'Error';
      setTimeout(() => d.value = '', 1000);
    }
  }
  else {
    d.value += v;
  }
}
