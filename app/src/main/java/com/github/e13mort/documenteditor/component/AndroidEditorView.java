package com.github.e13mort.documenteditor.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class AndroidEditorView extends View {

    public AndroidEditorView(Context context) {
        super(context);
    }

    public AndroidEditorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @NonNull
    private EditorPresenter editorPresenter = new EditorPresenter(EditorModel.EMPTY, EditorView.EMPTY);

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        editorPresenter.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        editorPresenter.stop();
    }
}
