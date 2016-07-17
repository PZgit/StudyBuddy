/**
 * Created by gmaal on 25/05/2016.
 */

// var jurl = "https://87.106.149.172:1337/";
// var jurl = "https://10.31.70.233:1337/";
var jurl = "https://localhost:1337/"

var requestSent = false;

//erstellt neuen User
function signInCallback(authResult) {
    if (!requestSent) {
        requestSent = true;
        // console.log('authResult: ' + JSON.stringify(authResult));
        var text = '{"code":"' + authResult.code + '"}';
        if (authResult['code']) {
            $.ajax({
                type: 'POST',
                url: jurl +'users',
                headers: {
                    'token': buildUserToken(JSON.parse(text))
                },
                contentType: 'application/json, charset=utf-8',
                success: function (result) {
                    console.log(result);
                },
                complete: function() {
                    requestSent = false;
                }
            });
        }
    }
};

//holt den user mit der angegebenen id bzw. mailadresse
function getUserById(userIdOrMail) {
    $.ajax({
        type: 'GET',
        url: jurl + 'users/' + userIdOrMail,
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json, charset=utf-8',
        success: function (result) {
            console.log(result);
            return result;
        }
    })
}

//löscht den user mit der angegebenen id
function getUserById(userId) {
    $.ajax({
        type: 'DELETE',
        url: jurl + 'users/' + userId,
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json, charset=utf-8',
        success: function (result) {
            console.log(result);
        }
    })
}

//holt alle events des angegebenen users
function getAllEventsForUser(userId) {
    $.ajax({
        type: 'GET',
        url: jurl + 'users/' + userId + '/events',
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
            return data;
        }
    })
}

//erstellt neues event aus formulardaten
function postNewEventByForm(eventForm) {
    var json = '{' +
        '"title": "' + eventForm.title.value + '",' +
        '"start": "' + eventForm.startdate.value + '",' +
        '"end": "' + eventForm.enddate.value + '",' +
        '"lecturer": "' + eventForm.lecturer.value + '",' +
        '"type": "' + eventForm.type.value + '",' +
        '"building": "' + eventForm.building.value + '",' +
        '"room": "' + eventForm.room.value + '"}';
    $.ajax({
        type: 'POST',
        url: jurl + 'users/' + uid + '/events',
        headers: {
            'token': buildUserToken(JSON.parse(json))
        },
        contentType: 'application/json, charset=utf-8',
        success: function (result) {
            console.log(result)
        }
    })
}

//erstellt neues event aus objekt
function postNewEventByObject(obj) {
    var text = '{' +
        '"title": "' + obj.name + '",' +
        '"start": "' + obj.startdate + '",' +
        '"end": "' + obj.enddate + '",' +
        '"lecturer": "' + obj.lecturers[0] + '",' +
        '"type": "' + obj.type + '",' +
        '"building": "' + "SHL(temp)" + '",' +
        '"room": "' + obj.room + '"}';
    $.ajax({
        type: 'POST',
        url: jurl + 'users/' + uid + '/events',
        headers: {
            'token': buildUserToken(JSON.parse(text))
        },
        contentType: 'application/json, charset=utf-8',
        success: function (result) {
            console.log(result)
        }
    })
}

//erstellt neues event aus objekt, das event-array enthält
function postAllEvents(eventCollection) {
    var wholeObj = JSON.parse(eventCollection);
    for (var i = 0; i < wholeObj.details.length; i++) {
        // console.log("Current single Object: " + "--" + wholeObj.details[i].eventid + "--" + wholeObj.details[i].name);
        postNewEventByObject(wholeObj.details[i]);
    }
}

//löscht event mit der angegebenen event-id
function deleteEvent(eventId) {
    $.ajax({
        type: 'DELETE',
        url: jurl + 'users/' + uid + '/events/' + eventId,
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        success: function (result) {
            console.log('deleted' + result)
        }
    })
}

//holt alle lerngruppen des angegebenen users
function getStudygroupsByUser(userid) {
    $.ajax({
        type: 'GET',
        url: jurl + 'users/' + userid + '/events',
        headers: {
            'token': buildUserToken(JSON.parse())
        },
        contentType: 'application/json, charset=utf-8',
        success: function (result) {
            console.log(result);
            return result;
        }
    })
}

function mockEvent(uid) {
    var text = '{"id": "' + uid + '",' +
        '"event": {' +
        '"title": "Test Event",' +
        '"start": "2016-05-25T13:00:00Z",' +
        '"end": "2016-05-25T14:00:00Z",' +
        '"lecturer": "Prof. Dr. med Wurst",' +
        '"type": "Vorlesung",' +
        '"building": "SHL",' +
        '"room": "H1.1"' +
        '}' +
        '}';
    var obj = JSON.parse(text);
    console.log(obj);
    return obj;
}



//studygroup methods

//holt alle lerngruppen
function getAllStudygroups() {
    $.ajax({
        type: 'GET',
        url: jurl + 'studygroups',
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
            return data;
        }
    })
}

//erstellt neue Lerngruppe
function postNewStudygroup(name) {
    var json = '{' +
        '"title": "' + name + '",' +
        '"admin": "' + uid + '"}';
    $.ajax({
        type: 'POST',
        url: jurl + 'studygroups',
        headers: {
            'token': buildUserToken(JSON.parse(json))
        },
        contentType: 'application/json, charset=utf-8',
        success: function (result) {
            console.log(result)
        }
    })
}

//holt lerngruppe per id
function getStudygroupById(id) {
    $.ajax({
        type: 'GET',
        url: jurl + 'studygroups/' + id,
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
            return data;
        }
    })
}

//löscht lerngruppe per id
function deleteStudygroupById(id) {
    $.ajax({
        type: 'DELETE',
        url: jurl + 'studygroups/' + id,
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
        }
    })
}

//holt lerngruppenadmin per id
function getStudygroupAdminById(id) {
    $.ajax({
        type: 'GET',
        url: jurl + 'studygroups/' + id + '/admin',
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
            return data;
        }
    })
}

//holt alle user der lerngruppe
function getStudygroupMembersById(id) {
    $.ajax({
        type: 'GET',
        url: jurl + 'studygroups/' + id + '/members',
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
            return data;
        }
    })
}

//fügt user lerngruppe hinzu
function putStudygroupMemberById(id) {
    var json = '{' +
        '"id": "' + id + '"}';
    $.ajax({
        type: 'PUT',
        url: jurl + 'studygroups/' + id + '/members',
        headers: {
            'token': buildUserToken(JSON.parse(json))
        },
        contentType: 'application/json, charset=utf-8',
        success: function (result) {
            console.log(result)
        }
    })
}

//löscht user aus lerngruppe
function deleteStudygroupMember(groupid, userid) {
    $.ajax({
        type: 'DELETE',
        url: jurl + 'studygroups/' + groupid + '/members/' + userid,
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
        }
    })
}

//holt alle events der lerngruppe
function getAllStudygroupEvents(id) {
    $.ajax({
        type: 'GET',
        url: jurl + 'studygroups/' + id + '/events',
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
            return data;
        }
    })
}

//verknüpft event mit lerngruppe
function putStudygroupEvent(groupid, eventid) {
    var json = '{' +
        '"id": "' + eventid + '"}';
    $.ajax({
        type: 'PUT',
        url: jurl + 'studygroups/' + groupid + '/events',
        headers: {
            'token': buildUserToken(JSON.parse(json))
        },
        contentType: 'application/json, charset=utf-8',
        success: function (result) {
            console.log(result)
        }
    })
}

//löscht user aus lerngruppe
function deleteStudygroupMember(groupid, eventid) {
    $.ajax({
        type: 'DELETE',
        url: jurl + 'studygroups/' + groupid + '/events/' + eventid,
        headers: {
            'token': buildUserToken(JSON.parse(''))
        },
        contentType: 'application/json charset=utf-8',
        success: function(data) {
            console.log(data);
        }
    })
}