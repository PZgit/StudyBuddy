/**
 * Created by sigg on 7/15/16.
 */

function makeDatatable(){

    // var pickerinit = '<div id="dsel2" style="width:568px"> </div>' + '<br>' + '<span id="wtf"></span>';
    //
    // $("#pickeranchor").append(pickerinit);
    
    
    
    var newTable = '<table id="example" class="mdl-data-table no-wrap" cellspacing="0" width="100%">' +
        '<thead><tr><th>Uhrzeit</th>' +
        '<th>Titel</th>' +
        '<th>Dozent</th>' +
        '<th>Raum</th>' +
        '<th>eventid</th>' +
        '<th>startdate</th>' +
        '<th>Editieren</th>' +
        '</tr>' +
        '</thead></table>';

    $("#tableanchor").append(newTable);


    var data = JSON.parse(jsonBehemoth);
    $("#example").DataTable({

        "dom": 't',
        "processing": true,
        "bInfo" : false,
        "menu" : false,
        "info": false,
        "search": false,
        "select": true,
        responsive: true,
        "data": data.details,

        language: {
            search: "Suche:",
            info: "_START_ bis _END_ von _TOTAL_ Einträgen",
            zeroRecords: "Keine Veranstaltungen für dieses Datum gefunden.",
            paginate: {
                first:      "Erste",
                previous:   "Zurück",
                next:       "Nächste",
                last:       "Letzte"
            },
        },

        columns: [

            { data: "startdate",
                render: function (data, type, full) {
                    return convertDate(full["startdate"], 8) + " - " + convertDate(full["enddate"], 8);
                }},

            { data: "module",
                render: function(data, type, full) {
                    if (full["group"] == "") return data.label
                    else return data.label + " (" + full["group"] + ")";
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
                visible: false },

            { data: "startdate",
                visible : false,
                render: function (data) {
                    var x = new Date(parseInt(data));
                    x.setHours(0);
                    x.setMinutes(0);
                    return x.getTime();
                }
            },

            {
                data: null,
                defaultContent: '<a href="#modalaskdelete" data-target="dialog-confirm" class="waves-effect waves-circle waves-light btn-floating secondary-content modal-trigger"> <i class="material-icons" onclick="delrow()">edit</i></a>'

            }

        ],




        "createdRow": function (row, data, dataIndex) {

            $(row).addClass(data.type);
        }
    });



    //testbutton für batch-export
    // $("#example").append('<button onclick="postAllEvents(jsonBehemoth);">create all events from behemoth</button>');
    // $("#example").append('<button onclick="delrow();">delrow</button>');
};

function delrow() {
    var table = $('#example').DataTable();
    var kabloing = table.row('.selected', 0).data().eventid;
    //var boing = table.row('selected').data("room");
    //console.log(boing);
    console.log(kabloing);
    var rows = table.rows( '.selected' ).remove().draw();
    deleteEvent(kabloing);
} ;


