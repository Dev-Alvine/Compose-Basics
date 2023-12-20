package com.alvine.tabtesting.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.alvine.composecodelab.R
import com.alvine.tabtesting.data.Account

@Composable
fun AccountBody(accounts:List<Account> ) {
    StatementBody(
        items=accounts,
        amounts ={account -> account.balance},
        colors = { account -> account.color },
        amountsTotal = accounts.map { account -> account.balance }.sum(),
        circleLabel = stringResource(R.string.total),
        rows = { account ->
            AccountRow(
                name = account.name,
                number = account.number,
                amount = account.balance,
                color = account.color
            )
        }
    )
}