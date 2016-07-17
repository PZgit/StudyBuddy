

var prevHtml;
var jsonStudiengang;
var jsonSemester;
var jsonModules = [];
var jsonLectures = [];
var jsonEventDetails;
var jsonBehemoth;

function getStudiengang() {
    $.getJSON("http://backend2.applab.fhws.de:8080/fhwsapi/v1/lectures/", function(data) {
        var baseUrlLectures = data[0].url + "/";
        // console.log(baseUrlLectures);
        $.getJSON(baseUrlLectures, function(data) {
            jsonStudiengang = data;
            showStudiengang(data);
        })
    });
}


// Schritt 1
function showStudiengang(studiengangdata) {
    jsonBehemoth = '{"details": ['; //first line in json containing all event-details
    var newHtml = '<div class="studiengangListe col s4"><p>Studiengang auswählen</p><form>';
    var programs = studiengangdata.programs;

    for (var i in programs) {
        //console.log(programs[i])
        newHtml += '\n<input type="radio" class="with-gap" name="studiengang" value="' +

            programs[i].url + '" id="' + programs[i].url +
            '"> <label for="' + programs[i].url + '">' + programs[i].label
            +
            '</label> <br>';
    }

    newHtml += '\n<p><input name="buttonSemester" type="button" value="Semester auswählen" class="btn waves-effect waves-light deep-orange" onclick="getSemester(studiengang.value)"></p>' +
        '\n</form>' +
        '\n</div>';
    document.formStudiengang.innerHTML = newHtml;

}

// function showStudiengang(studiengangdata) {
//     //console.log(studiengangdata);
//     var newHtml = '<div class="input-field col s4">Studiengang auswählen<select>';
//     var programs = studiengangdata.programs;
//
//     for (var i in programs) {
//         //console.log(programs[i])
//         newHtml += '\n<option id="studiengang" value="' + programs[i].url + '">' + programs[i].label + '</option>';
//     }
//
//     newHtml += '\n</select><p><input name="buttonSemester" type="button" value="Semester auswählen" class="btn waves-effect waves-light deep-orange" onclick="getSemester(studiengang.value)"></p></input>' +
//         + '\n</div>';
//     document.formStudiengang.innerHTML = newHtml;
// }




function getSemester(url) {
    if (url == "") alert('Bitte Studiengang auswählen');
    $.getJSON(url, function(data, status) {
        jsonSemester = data;
        //console.log("getSemester: " + status);
        showSemester(data);
    })
}

function showSemester(semesterdata) {
    prevHtml = document.getElementsByClassName("lWizard")[0].innerHTML;
    document.formStudiengang.buttonSemester.disabled = true;
    document.formStudiengang.buttonSemester.style.visibility = "hidden";
    var newHtml = '<div id="testme" class="fSemester col s4">' + '<p>Studiensemester auswählen</p>' +
        '<form name="formSemester">';
    var sessions = semesterdata.sessions;
    for (var i in sessions) {
        //console.log(sessions[i]);
        newHtml += '\n<input type="checkbox" value="' +
            sessions[i].url + '" id="semesteroption' + i + '"> <label for="semesteroption' + i +'">' +

            sessions[i].label +
            ' </label> <br>';
    }
    newHtml += '\n<p><input id="buttonModules" type="button" value="Semester auswählen" class="btn waves-effect waves-light deep-orange" onclick="getModules(this.form)"></p>' +
            '<p><input name="buttonBackStudiengang" type="button" value="zurück" class="btn waves-effect waves-light deep-orange" onclick="backStudiengang()"</p>' +
        '\n</form>' +
        '\n</div>';
    $(".lWizard").append(newHtml);
}

function backStudiengang() {
    jsonSemester = null;
    $(".lWizard").empty();
    $(".lWizard").append('<form name="formStudiengang"></form>');
    showStudiengang(jsonStudiengang);
}

function backSemester() {
    jsonModules = [];
    $(".lWizard").empty();
    $(".lWizard").append(prevHtml);
}

function getModules(form) {
    var url = getChecked(form);
    url.sort();
    var successcounter = 0;
    for (var i = 0; i < url.length; i++) {
        console.log(url[i]);
        $.getJSON(url[i], function (data, status) {
            jsonModules.push(data);
            //console.log("getLectures: " + status);
            //console.log(jsonLectures);
            successcounter++;
            if (successcounter == url.length) showModules(jsonModules);
        })
    }
}


function showModules(moduledata) {
    console.log(moduledata);
    prevHtml = document.getElementsByClassName("lWizard")[0].innerHTML;
    document.formSemester.buttonModules.disabled = true;
    document.formSemester.buttonModules.style.visibility = "hidden";
    document.formSemester.buttonBackStudiengang.disabled = true;
    document.formSemester.buttonBackStudiengang.style.visibility = "hidden";
    var newHtml = '<div class="fModules col s4">' + '<p>Module auswählen</p>'  +
        '<form name="formModules">';
    for (var j = 0; j < moduledata.length; j++) {
        var modules = moduledata[j].modules;
        for (var i = 0; i < modules.length; i++) {
            //console.log(modules[i]);
            newHtml += '\n<input type="checkbox" value="' +
                modules[i].url +
                '" id="moduleoption' + i + '" checked="checked"> <label for="moduleoption' + i +'">' +
                modules[i].label + '</label> <br>';
        }
    }
    newHtml += '\n<p><input name="buttonLectures" type="button" class="btn waves-effect waves-light deep-orange" value="Fertig" onclick="getLectures(this.form)"></p>' +
            '<p><input name="buttonBackSemester" type="button" value="zurück" class="btn waves-effect waves-light deep-orange" onclick="backSemester()"></p>'
        '\n</form>' +
        '\n</div>';
    $(".lWizard").append(newHtml);
}

function getLectures(form) {

    // document.formModules.buttonLectures.disabled = true;
    var url = getChecked(form);
    var successcounter = 0;
    for (var i = 0; i < url.length; i++) {
        $.getJSON(url[i], function (data, status) {
            jsonLectures.push(data);
            //console.log("getLectures: " + status);
            // console.log(jsonLectures);
            successcounter++;
            if (successcounter == url.length) showLectures(jsonLectures);
        })
    }
    // var newHtml = '<button onclick="showLectures(jsonLectures)">weiter</button>';
    // $(".lWizard").append(newHtml);
}

function showLectures(lecturedata) {
    var lectureUrls = [];
    for (var x = 0; x < lecturedata.length; x++) {
        var tempUrl = lecturedata[x].events;
        for (var y in tempUrl) {
            lectureUrls.push(tempUrl[y].url)
        }
    }
    for (var z in lectureUrls) {
        console.log("URL: " + lectureUrls[z])
    }
    getEventDetailsNew(lectureUrls);
    /*var newHtml = '<div class="fLectures">' +
        '<form name="formLectures">'/!* +
     '\n<p>Dozenten:</p>';
     var lecturers = lecturedata.lecturers;
     for (var i in lecturers) {
     newHtml += '\n' + lecturers[i].label + '<br>';
     }*!/

    newHtml += '\n<p>Vorlesungen</p>';
    for (var j = 0; j < lecturedata.length; j++) {
        var events = lecturedata[j].events;
        for (var i in events) {
            console.log(events[i]);
            newHtml += '\n<input type="checkbox" name="lecture" value="' +
                events[i].url +
                '" checked>' +
                events[i].label +
                '<br>';
        }
    }
    newHtml += '\n<p><input type="button" value="Details" onclick="getEventDetails(this.form)"></p>' +
        '\n</form>' +
        '\n</div>' +
        '<div class="eventDetails"></div>';
    $(".lWizard").append(newHtml);*/
}


function getEventDetails(form) {
    var url = getChecked(form);
    // for (var i = 0; i < url.length; i++) {
    for (var i in url) {
        $.getJSON(url[i], function(data, status) {
            jsonEventDetails = data;
            // console.log("getEventDetails: " + status);
            // $(".eventDetails").empty();
            showEventDetailsNew(data);

            jsonBehemoth += JSON.stringify(data) + ',';
            // console.log(jsonBehemoth);
            /*if (i == (url.length - 1)) {
             jsonBehemoth = jsonBehemoth.slice(0, (jsonBehemoth.length-1));
             jsonBehemoth += ']}';
             console.log('bla' + jsonBehemoth);
             console.log(JSON.parse(jsonBehemoth));
             }*/
        })
    }
    $(".eventDetails").append('<button onclick="finalizeJson()">Finalize JSON</button>');
    //<button onclick="makeTable()">Mach de Tabelle')
    //$(".eventDetails").append('<button onclick="makeDatatable()">Mach de dataTabelle');
    // finalizeJson();
}

function getEventDetailsNew(urls) {
    // eliminateDuplicates(urls);
    var successcounter = 0;
    for (var i in urls) {
        $.getJSON(urls[i], function (data) {
            jsonEventDetails = data;
            jsonBehemoth += JSON.stringify(data) + ',';
            successcounter++;
            if (successcounter == urls.length) finalizeJson();
        })
    }
}

function eliminateDuplicates(urls) {
    // for (var a in urls) console.log('Dirty List: ' + urls[a]);
    var uniqueUrls = [];
    for (var i = 0; i < urls.length; i++) {
        var iString = getUrlSubstring(urls[i]);
        if (urls[i] != 'DUPLICATE') {
            for (var j = i + 1; j < urls.length - 1; j++) {
                var jString = getUrlSubstring(urls[j]);
                if (iString == jString) {
                    urls[i + j] = 'DUPLICATE';
                }
            }
            uniqueUrls.push(uniqueUrls[i])
        }
    }
    // for (var b in uniqueUrls) console.log('Clean List: ' + uniqueUrls[b]);
    return uniqueUrls;
}

function getUrlSubstring(text) {
    for (var i = 1; i < text.length; i++) {
        if (text.charAt(text.length - i) == "/") return text.substring(text.length - i + 1, text.length - 1)
    }
}

function showEventDetails(detailData) {
    // console.log(detailData);
    var newHtml = '<div class="row"><div class="col s12 m6"><div class="card grey darken-1"><div class="card-content white-text"><table class="eventDetailsTable" border="1"><tbody>' +
        '<tr>' +
        '<td>name</td>' +
        '<td>' + detailData.name + '</td>' +
        '</tr>' +
        '<tr>' +
        '<td>startdate</td>' +
        '<td>' + detailData.startdate + '</td>' +
        '</tr>' +
        '<tr>' +
        '<td>enddate</td>' +
        '<td>' + detailData.enddate + '</td>' +
        '</tr>' +
        '<tr>' +
        '<td>label</td>' +
        '<td>' + detailData.label + '</td>' +
        '</tr>' +
        '<tr>' +
        '<td>lecturers</td>' +
        '<td>';
    var lecturers = detailData.lecturers;
    for (var i in detailData.lecturers) {
        newHtml += lecturers[i].label + '<br>';
    }
    newHtml += '</td>' +
        '</tr>' +
        '<tr>' +
        '<td>type</td>' +
        '<td>' + detailData.type + '</td>' +
        '</tr>' +
        '<tr>' +
        '<td>note</td>' +
        '<td>' + detailData.note + '</td>' +
        '</tr>' +
        '<tr>' +
        '<td>group</td>' +
        '<td>' + detailData.group + '</td>' +
        '</tr>' +
        '<tr>' +
        '<td>room</td>' +
        '<td>' + detailData.room + '</td>' +
        '</tr>' +
        '</tbody></table></div></div></div></div>';
    $(".eventDetails").append(newHtml);
    console.log(JSON.stringify(detailData));
}

function getChecked(form) {
    var inpfields = form.getElementsByTagName('input');
    var nrInpfields = inpfields.length;
    var values = [];

    for (var i = 0; i < nrInpfields; i++) {
        if(inpfields[i].type == 'checkbox' && inpfields[i].checked == true) values.push(inpfields[i].value);
    }
    if (values.length == 0) alert('min. 1 Element auswählen')
    else return values;
}



function finalizeJson() {
    jsonBehemoth = jsonBehemoth.slice(0, (jsonBehemoth.length-1));
    jsonBehemoth += ']}';
    // console.log('Finished:');
    //console.log(jsonBehemoth);
    //console.log(JSON.parse(jsonBehemoth));
    makeDatatable();
    wipeWizard();
}

function wipeWizard() {
    $(".lWizard").empty();
    $(".lWizard").append('<form name="formStudiengang"></form>');
}


function makeDatatable(){

var newTable = '<thead><tr><th>Name</th>' +
    '<th>Start</th>' +
    '<th>Lecturers</th>' +
    '<th>Raum</th>' +
        '<th>ID</th>' +
    '</tr>' +
    '</thead>';

    $("#example").append(newTable);


    var data = JSON.parse(jsonBehemoth);
    $("#example").DataTable({

        "processing": true,

        "select": true,

        "data": data.details,



        columns: [
/*            { data: "name",
                render: function (data, type, full) {
                    if (full["group"] == "") return full["name"]
                    else return full["name"] + " (" + full["group"] + ")";
                }},*/

            { data: "module",
              render: function(data, type, full) {
                  if (full["group"] == "") return data.label
                  else return data.label + " (" + full["group"] + ")";
              }},

            /*            { data: "startdate",
             render: function (data) {
             return convertDate(data, 7)
             }},
             { data: "enddate",
             render: function (data) {
             return convertDate(data, 7)
             }},*/

            { data: "startdate",
                render: function (data, type, full) {
                    return convertDate(full["startdate"], 7) + " - " + convertDate(full["enddate"], 8);
                }},
            { data: "lecturers",
                render: function (data) {
                    var strLecturers = "";
                    for (var i in data)  {
                        strLecturers += data[i].label + "," + "<br>";
                    }
                    return strLecturers.slice(0, strLecturers.length - 5);
                }
            },


            // { data: "group" },
            { data: "room" },

            { data: "eventid",
            visible: false }


        ],

        "createdRow": function (row, data, dataIndex) {
            $(row).addClass(data.type);
        }




    });
    //testbutton für batch-export
    $("#example").append('<button onclick="postAllEvents(jsonBehemoth);">create all events from behemoth</button>');

}






function convertDate(din, dformat) {
    var iso = new Date(din);
    if (dformat == 1) return iso.getTime();
    if (dformat == 2) return iso;

    var sdate = iso.getDate();
    var date0 = (sdate < 10) ? "0" : "";

    var smonth = iso.getMonth() + 1;
    var month0 = (smonth < 10) ? "0": "";

    var de = date0 + sdate + "." + month0 + smonth + "." + iso.getFullYear();
    if (dformat == 3) return de;

    var day = new Array();
    day[0] = "Sonntag";
    day[1] = "Montag";
    day[2] = "Dienstag";
    day[3] = "Mittwoch";
    day[4] = "Donnerstag";
    day[5] = "Freitag";
    day[6] = "Samstag";
    var sday = day[iso.getDay()];

    var tmonth = new Array();
    tmonth[0]="Januar";
    tmonth[1]="Februar";
    tmonth[2]="März";
    tmonth[3]="April";
    tmonth[4]="Mai";
    tmonth[5]="Juni";
    tmonth[6]="Juli";
    tmonth[7]="August";
    tmonth[8]="September";
    tmonth[9]="October";
    tmonth[10]="November";
    tmonth[11]="Dezember";
    var lmonth = tmonth[iso.getMonth()];

    var text = sday + ", " + date0 + sdate + ". " + lmonth + " " + iso.getFullYear();
    if (dformat == 4) return text;

    var shours = iso.getHours();
    var hours0 = (shours < 10) ? "0": "";
    var sminutes = iso.getMinutes();
    var minutes0 = (sminutes < 10) ? "0": "";

    var epic = text + ", " + hours0 + shours + ":" + minutes0 + sminutes + " Uhr";
    if (dformat == 5) return epic;
}