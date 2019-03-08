package com.github.e13mort.documenteditor.component;

import android.support.annotation.NonNull;

class EditorPresenter {
    @NonNull
    private final EditorModel model;
    @NonNull
    private final EditorView view;

    EditorPresenter(@NonNull EditorModel model, @NonNull EditorView view) {
        this.model = model;
        this.view = view;
    }

    void start() {

    }

    void stop() {

    }
}
