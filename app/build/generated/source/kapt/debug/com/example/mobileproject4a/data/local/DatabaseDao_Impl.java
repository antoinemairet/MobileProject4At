package com.example.mobileproject4a.data.local;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mobileproject4a.data.local.models.UserLocal;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseDao_Impl implements DatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserLocal> __insertionAdapterOfUserLocal;

  private final EntityDeletionOrUpdateAdapter<UserLocal> __deletionAdapterOfUserLocal;

  public DatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserLocal = new EntityInsertionAdapter<UserLocal>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `UserLocal` (`uid`,`email`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserLocal value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getUid());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
      }
    };
    this.__deletionAdapterOfUserLocal = new EntityDeletionOrUpdateAdapter<UserLocal>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `UserLocal` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserLocal value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getUid());
        }
      }
    };
  }

  @Override
  public void insert(final UserLocal user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserLocal.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final UserLocal user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUserLocal.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<UserLocal> getAll() {
    final String _sql = "SELECT * FROM userlocal";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final List<UserLocal> _result = new ArrayList<UserLocal>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserLocal _item;
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item = new UserLocal(_tmpEmail);
        final Integer _tmpUid;
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _tmpUid = null;
        } else {
          _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        }
        _item.setUid(_tmpUid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UserLocal findByName(final String email) {
    final String _sql = "SELECT * FROM userLocal WHERE email LIKE ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final UserLocal _result;
      if(_cursor.moveToFirst()) {
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result = new UserLocal(_tmpEmail);
        final Integer _tmpUid;
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _tmpUid = null;
        } else {
          _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        }
        _result.setUid(_tmpUid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
