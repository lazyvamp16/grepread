function addQuestion(){


    var textArea = document.createElement("textarea");
    textArea.id= "textarea2";
    textArea.cols= "50";
    textArea.rows= "50";
    textArea.style="para";
    textArea.style.position= "relative";
    textArea.style.position= "relative"
    document.body.appendChild(textArea);

}

let count=0;
var formfield = document.getElementById('formfield');

function add(){
  count++;
  var newField = document.createElement('textarea');
  newField.setAttribute('id','textarea2');
  newField.setAttribute('name','text');
  newField.setAttribute('class','text option-textarea');
  newField.setAttribute('placeholder','Enter question...');
  formfield.appendChild(newField);
  addq();

}

function addq(){
    count++;
    var newField = document.createElement('textarea');
    newField.setAttribute('id','textarea3');
    newField.setAttribute('name','text');
    newField.setAttribute('class','text option-textarea');
    newField.setAttribute('placeholder','Enter ONLY options(no A B C D or 1 2 ... etc.) (one option in each line without).."\n"A"\n"B"\n"C"\n"D');
    formfield.appendChild(newField);
}

function remove(){
  count = count - 2;
  var input_tags = formfield.getElementsByTagName('textarea');
  if(input_tags.length > 2) {
    formfield.removeChild(input_tags[(input_tags.length) - 1]);
    formfield.removeChild(input_tags[(input_tags.length) - 1]);
  }
}

function generateTextFile() {
    const para = document.getElementById('textarea1').value;
    const question = document.getElementById('textarea2').value;
    const options = document.getElementById('textarea3').value;
    let newoptions='';
    // for (let i = 1; i <= count; i++) {
    //     const optionTextArea = document.getElementsByClassName('text' + i);
    //     newoptions += optionTextArea.value.trim() + '\n';
    //}
    //Combine question and options into a single string
    const optionTextAreas = document.querySelectorAll('.option-textarea');
    optionTextAreas.forEach(optionTextArea => {
        newoptions += optionTextArea.value.trim() + '\n';
    });

    const textToSave = para + '\n' + question + '\n' + options + '\n' + newoptions;

    const blob = new Blob([textToSave], { type: 'text/plain' });
    const url = URL.createObjectURL(blob);

    const downloadLink = document.createElement('a');
    downloadLink.href = url;
    downloadLink.download = 'question_and_options.txt';
    downloadLink.textContent = 'Click here to download the text file';

    const downloadLinkContainer = document.getElementById('download-link');
    downloadLinkContainer.innerHTML = ''; // Clear any previous link
    downloadLinkContainer.appendChild(downloadLink);
}


