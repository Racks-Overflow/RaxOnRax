import { useState } from 'react';

import Modal from '../ui/ModalBackdrop';
import Backdrop from '../ui/Backdrop';
  

function PayModal(props) {
  const [modalIsOpen, setModalIsOpen] = useState(false);

  function deleteHandler() {
    setModalIsOpen(true);
  }

  function closeModalHandler() {
    setModalIsOpen(false);
  }

  return (
    <div>
      <h4>Your balance is {props.balance}.</h4>
      <div className='actions'>
        <button className='btn' onClick={deleteHandler}>
          Pay Balance
        </button>
      </div>
      {modalIsOpen && (
        <Modal onCancel={closeModalHandler} onConfirm={closeModalHandler} />
      )}
      {modalIsOpen && <Backdrop onCancel={closeModalHandler} />}
    </div>
  );
}

export default PayModal;
