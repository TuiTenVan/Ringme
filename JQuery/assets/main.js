$(document).ready(function () {
    fetchStudents();

    // Hiển thị danh sách sinh viên
    function fetchStudents() {
        $.ajax({
            url: 'http://localhost:3000/students',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                displayStudents(data);
            },
            error: function (xhr, status, error) {
                console.error('Error fetching students:', error);
            }
        });
    }

    $("#checkAll").change(function () {
        var checked = $(this).prop("checked");
        $(".student-checkbox").prop("checked", checked);
    });

    function displayStudents(students) {
        $("#student-list").empty();
        $.each(students, function (index, student) {
            var row = "<tr data-id='" + student.id + "'>";
            row += "<td><input type='checkbox' class='student-checkbox'></td>";
            row += "<td>" + student.name + "</td>";
            row += "<td>" + student.birthday + "</td>";
            row += "<td>" + student.mobilePhone + "</td>";
            row += "<td>" + student.hometown + "</td>";
            row += "</tr>";
            $("#student-list").append(row);
        });
    }

    // Thêm mới sinh viên hoặc cập nhật thông tin sinh viên
    $("#student-form").submit(function (event) {
        event.preventDefault();
        var id = $("#student-form").attr("data-id"); 
        var name = $("#name").val();
        var birthday = $("#birthday").val();
        var mobilePhone = $("#mobilePhone").val();
        var hometown = $("#hometown").val();
    
        var data = {
            name: name,
            birthday: birthday,
            mobilePhone: mobilePhone,
            hometown: hometown
        };
    
        if (!id) {
            var maxId = getMaxId();
            data.id = maxId + 1 + ""; 
        }
    
        $.ajax({
            url: 'http://localhost:3000/students' + (id ? '/' + id : ''), 
            type: id ? 'PUT' : 'POST', 
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                console.log('Student ' + (id ? 'updated' : 'added') + ' successfully:', response);
                fetchStudents();
                $("#student-form")[0].reset();
                $("#save-btn").prop("disabled", true);
            },
            error: function (xhr, status, error) {
                console.error('Error ' + (id ? 'updating' : 'adding') + ' student:', error);
            }
        });
    
        this.reset();
    });
    

    function getMaxId() {
        var maxId = 0;
        $("#student-list").find("tr").each(function () {
            var id = parseInt($(this).attr("data-id"));
            if (id > maxId) {
                maxId = id;
            }
        });
        return maxId;
    }

    $("#edit-btn").click(function () {
        var checkedStudents = $(".student-checkbox:checked");
        if (checkedStudents.length !== 1) {
            alert("Bạn chỉ được sửa thông tin của 1 sinh viên");
        } else {
            var id = checkedStudents.closest("tr").attr("data-id");
            getStudent(id).done(function (student) {
                $("#name").val(student.name);
                $("#birthday").val(student.birthday);
                $("#mobilePhone").val(student.mobilePhone);
                $("#hometown").val(student.hometown);
                $("#student-form").attr("data-id", id);
                $("#save-btn").prop("disabled", false);
            }).fail(function (xhr, status, error) {
                console.error('Error fetching student for editing:', error);
            });
        }
    });

    // Lấy thông tin sinh viên từ server
    function getStudent(id) {
        return $.ajax({
            url: 'http://localhost:3000/students/' + id,
            type: 'GET',
            dataType: 'json'
        });
    }

    // Xóa sinh viên
    $(document).on("change", ".student-checkbox", function () {
        updateButtonState();
    });

    $("#delete-btn").click(function () {
        var confirmed = confirm("Bạn có chắc chắn muốn xóa sinh viên đang chọn?");
        if (confirmed) {
            $(".student-checkbox:checked").each(function () {
                var id = $(this).closest("tr").attr("data-id");

                deleteStudent(id);
                $(this).closest("tr").remove();
            });
            updateButtonState();
        }
    });

    function updateButtonState() {
        var checked = $(".student-checkbox:checked").length > 0;
        $("#delete-btn, #edit-btn").prop("disabled", !checked);
    }

    function deleteStudent(id) {
        $.ajax({
            url: 'http://localhost:3000/students/' + id,
            type: 'DELETE',
            success: function (response) {
                console.log('Student deleted successfully:', response);
            },
            error: function (xhr, status, error) {
                console.error('Error deleting student:', error);
            }
        });
    }
});
