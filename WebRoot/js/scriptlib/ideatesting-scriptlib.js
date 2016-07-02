$(document).ready(function(){
    // FOO TABLES
    // =================================================================
    // Require FooTable
    // -----------------------------------------------------------------
    // http://fooplugins.com/footable-demos/
    // =================================================================


    // Row Toggler
    // -----------------------------------------------------------------
    $('#demo-foo-row-toggler').footable();




    // Expand / Collapse All Rows
    // -----------------------------------------------------------------
    var fooColExp = $('#demo-foo-col-exp');
    fooColExp.footable().trigger('footable_expand_first_row');


    $('#demo-foo-collapse').on('click', function(){
        fooColExp.trigger('footable_collapse_all');
    });
    $('#demo-foo-expand').on('click', function(){
        fooColExp.trigger('footable_expand_all');
    })





    // Accordion
    // -----------------------------------------------------------------
    $('#demo-foo-accordion').footable().on('footable_row_expanded', function(e) {
        $('#demo-foo-accordion tbody tr.footable-detail-show').not(e.row).each(function() {
            $('#demo-foo-accordion').data('footable').toggleDetail(this);
        });
    });





    // Pagination
    // -----------------------------------------------------------------
    $('#demo-foo-pagination').footable();
    $('#demo-show-entries').change(function (e) {
        e.preventDefault();
        var pageSize = $(this).val();
        $('#demo-foo-pagination').data('page-size', pageSize);
        $('#demo-foo-pagination').trigger('footable_initialized');
    });
});