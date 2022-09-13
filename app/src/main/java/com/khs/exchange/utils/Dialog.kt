package com.khs.exchange.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.StringRes
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.khs.exchange.R
import com.khs.exchange.databinding.DialogLayoutBinding

class Dialog {

    companion object {
        @SuppressLint("InflateParams")
        fun showDialog(
            context: Context?,
            type: DialogType,
            @StringRes btnText: Int? = null,
            onClick: (() -> Unit)? = null
        ): BottomSheetDialog {
            val dialog = BottomSheetDialog(context!!)
            val binding: DialogLayoutBinding =
                DialogLayoutBinding.inflate(LayoutInflater.from(context), null,false)
            dialog.setContentView(binding.root)
            when (type) {
                is DialogType.Error -> {
                    binding.dialogTitle.apply {
                        text = context.getString(R.string.error)
                    }
                }
                is DialogType.Warning -> {
                    binding.dialogTitle.apply {
                        text = context.getString(R.string.warning)
                    }
                }
                is DialogType.Success -> {
                    binding.dialogTitle.apply {
                        text = context.getString(R.string.success)
                    }
                }
                is DialogType.Info -> {
                    binding.dialogTitle.apply {
                        text = context.getString(R.string.info)
                    }
                }
            }
            binding.dialogBody.text = with(type){
                textStr ?: context.getString(type.text!!)
            }

            binding.close.text = btnText?.let {
                context.getString(it)
            } ?: context.getString(R.string.close)

            binding.close.setOnClickListener {
                onClick?.let {
                    it()
                }
                dialog.dismiss()
            }
            dialog.show()
            return dialog
        }
    }
}